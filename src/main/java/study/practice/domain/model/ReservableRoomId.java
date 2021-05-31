package study.practice.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ReservableRoomId implements Serializable {

    @Column(name = "room_id")
    private Long roomId; //@MapsId("room_id")로 매핑

    @Column(name = "reserved_date")
    private LocalDate reservedDate;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if(getClass() != obj.getClass()) {
            return false;
        }

        ReservableRoomId other = (ReservableRoomId) obj;
        if(reservedDate == null) {
            if(other.reservedDate != null) {
                return false;
            }
        } else if(!reservedDate.equals(other.reservedDate)) {
            return false;
        }

        if(roomId == null) {
            return other.roomId == null;
        } else return roomId.equals(other.roomId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((reservedDate == null) ? 0 : reservedDate.hashCode());
        result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
        return result;
    }
}
