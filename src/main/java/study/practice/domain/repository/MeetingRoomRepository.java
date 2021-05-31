package study.practice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.practice.domain.model.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {
}
