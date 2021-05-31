package study.practice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.practice.domain.model.ReservableRoom;
import study.practice.domain.repository.ReservableRoomRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomService {

    @Autowired
    ReservableRoomRepository roomRepository;

    public List<ReservableRoom> findReservableRooms(LocalDate date) {
        return roomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
    }
}
