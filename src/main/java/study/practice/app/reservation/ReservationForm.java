package study.practice.app.reservation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@EndTimeMustBeAfterStartTime(message = "종료 시간은 시작 시간보다 빠를 수 없습니다.")
public class ReservationForm implements Serializable {

    @NotNull(message = "필수 입력 항목입니다")
    @DateTimeFormat(pattern = "HH:mm")
    @ThirtyMinutesUnit(message = "30분 단위로 입력해주세요.")
    private LocalTime startTime;

    @NotNull(message = "필수 입력 항목입니다.")
    @DateTimeFormat(pattern = "HH:mm")
    @ThirtyMinutesUnit(message = "30분 단위로 입력해주세요")
    private LocalTime endTime;
}
