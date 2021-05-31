package study.practice.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import study.practice.domain.model.ReservableRoom;
import study.practice.domain.model.ReservableRoomId;

import java.time.LocalDate;
import java.util.List;

public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {
    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);
}
