package study.practice.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.practice.domain.model.ReservableRoom;
import study.practice.domain.model.ReservableRoomId;

import javax.persistence.LockModeType;
import java.time.LocalDate;
import java.util.List;

public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId> {

    //복합키가 reserveDate, roomId 순으로 정렬됨 -> where로 빠르게 조회하고, order로 빠르게 정렬할 수 있다
    @Query("SELECT DISTINCT r FROM ReservableRoom r "
            + "LEFT JOIN FETCH r.meetingRoom "
            + "WHERE r.reservableRoomId.reserveDate = :date "
            + "ORDER BY r.reservableRoomId.roomId ASC")
    List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(@Param("date") LocalDate reservedDate);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);
}
