package study.practice.domain.service.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.practice.domain.model.*;
import study.practice.domain.repository.reservation.ReservationRepository;
import study.practice.domain.repository.room.ReservableRoomRepository;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservableRoomRepository reservableRoomRepository;

    public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {
        return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);
    }

    public Reservation reserve(Reservation reservation) {
        ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();

        if(reservableRoomRepository.existsById(reservableRoomId)) {
            throw new UnavailableReservationException("선택한 날짜와 회의실로 예약할 수 없습니다");
        }

        boolean overlap = reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)
                .stream()
                .anyMatch(x -> x.overlap(reservation));

        if(overlap) {
            throw new AlreadyReservedException("입력한 시간대에 이미 예약된 건이 있습니다");
        }

        //예약 정보 등록
        return reservationRepository.save(reservation);
    }

    public void cancel(Integer reservationId, User requestUser) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalStateException("예약을 찾을 수 없습니다"));
        if (RoleName.ADMIN != requestUser.getRoleName()
                && !Objects.equals(reservation.getUser().getUserId(), requestUser.getUserId())) {
            throw new IllegalStateException("예약을 취소할 수 없습니다");
        }
        reservationRepository.delete(reservation);
    }
}
