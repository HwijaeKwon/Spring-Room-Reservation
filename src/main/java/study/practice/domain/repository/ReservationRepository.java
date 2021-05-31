package study.practice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.practice.domain.model.ReservableRoomId;
import study.practice.domain.model.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(
            ReservableRoomId reservableRoomId);
}