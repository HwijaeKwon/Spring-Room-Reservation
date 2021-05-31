package study.practice.domain.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import study.practice.domain.model.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
}
