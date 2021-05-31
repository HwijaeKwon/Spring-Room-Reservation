package study.practice.app.reservation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Data
public class ReservationForm implements Serializable {

    @NotNull(message = "필수 입력 항목입니다")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @NotNull(message = "필수 입력 항목입니다.")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;
}
