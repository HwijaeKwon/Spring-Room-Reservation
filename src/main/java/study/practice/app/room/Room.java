package study.practice.app.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import study.practice.domain.model.ReservableRoom;
import study.practice.domain.service.RoomService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("rooms")
public class Room {

    @Autowired
    RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    String listRooms(Model model) {
        LocalDate today = LocalDate.now();
        List<ReservableRoom> rooms = roomService.findReservableRooms(today);
        model.addAttribute("date", today);
        model.addAttribute("rooms", rooms);
        return "room/listRooms";
    }
}
