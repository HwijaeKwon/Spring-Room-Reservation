package study.practice.domain.service.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.practice.domain.model.MeetingRoom;
import study.practice.domain.model.ReservableRoom;
import study.practice.domain.repository.room.MeetingRoomRepository;
import study.practice.domain.repository.room.ReservableRoomRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class RoomService {

    @Autowired
    ReservableRoomRepository roomRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    public List<ReservableRoom> findReservableRooms(LocalDate date) {
        return roomRepository.findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(date);
    }

    public MeetingRoom findMeetingRoom(Integer roomId) {
        return meetingRoomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalStateException("회의실을 찾을 수 없습니다"));
    }
}
