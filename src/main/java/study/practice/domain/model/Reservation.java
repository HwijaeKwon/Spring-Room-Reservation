package study.practice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@Getter
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "room_id"),
            @JoinColumn(name = "reserved_date")
    })
    private ReservableRoom reservableRoom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
