package study.spring.springmvc.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import study.spring.springmvc.dto.member.Member;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @GetMapping("/")
    public String wellComePage(){
        return "wellComePage";
    }

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "login/loginForm";
    }
}
