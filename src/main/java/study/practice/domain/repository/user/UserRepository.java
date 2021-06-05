package study.practice.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import study.practice.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
