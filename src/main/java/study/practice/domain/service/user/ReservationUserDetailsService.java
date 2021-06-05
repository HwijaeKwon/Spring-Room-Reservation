package study.practice.domain.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import study.practice.domain.model.User;
import study.practice.domain.repository.user.UserRepository;

public class ReservationUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //사용자 정보를 가져오는 것은 UserRepository에 위임한다
        User user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " is not found."));
        return new ReservationUserDetails(user);
    }
}
