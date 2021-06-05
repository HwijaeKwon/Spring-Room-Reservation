package study.practice.domain.service.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import study.practice.domain.model.User;

import java.util.Collection;

public class ReservationUserDetails implements UserDetails {
    private final User user;

    public ReservationUserDetails(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //enum 형태로 만들어진 RoleName을 스프링 시큐리티가 인식할 수 있도록 GrantedAuthority 형태로 변환한다
        //이때 역할의 접두어 'ROLE_' 문자열이 추가된다
        return AuthorityUtils.createAuthorityList("ROLE_" + this.user.getRoleName().name());
    }

    @Override
    public String getPassword() {
        return this.user.getPassWord();
    }

    @Override
    public String getUsername() {
        return this.user.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
