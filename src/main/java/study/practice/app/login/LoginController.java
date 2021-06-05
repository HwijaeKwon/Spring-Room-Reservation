package study.practice.app.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class LoginController {

    @RequestMapping("loginForm")
    String loginForm() {
        return "login/loginForm";
    }
}

/*
@Configuration
public class WebMvcConfig extends WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("loginForm").setViewName("login/loginForm");
    }
}
*/

