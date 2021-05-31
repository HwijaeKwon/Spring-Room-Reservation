package study.practice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservable_room")
@AllArgsConstructor
@Getter
public class ReservableRoom implements Serializable {

    @EmbeddedId
    private ReservableRoomId reservableRoomId;

    @MapsId("roomId") //ReservableRoomId.roomId와 매핑
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private MeetingRoom meetingRoom;
}
