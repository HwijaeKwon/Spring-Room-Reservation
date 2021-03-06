package study.practice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@Getter
public class Reservation implements Serializable {

    @Id @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationId;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "reserved_date"),
            @JoinColumn(name = "room_id")
    })
    private ReservableRoom reservableRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public boolean overlap(Reservation target) {
        if (!Objects.equals(reservableRoom.getReservableRoomId(),
                target.reservableRoom.getReservableRoomId())) {
            return false;
        }

        if(startTime.equals(target.startTime) && endTime.equals(target.endTime)) {
            return true;
        }

        return target.endTime.isAfter(startTime) && endTime.isAfter(target.startTime);
    }

    public Reservation(LocalTime startTime, LocalTime endTime, ReservableRoom reservableRoom, User user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservableRoom = reservableRoom;
        this.user = user;
    }
}
