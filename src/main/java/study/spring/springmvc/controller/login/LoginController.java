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

    @GetMapping("/loginpage")
    public String loginPage(Model model){
        model.addAttribute("msg", "로그인을 해보세요.");
        System.out.println("loginpage");
        return "loginForm";
    }

    @GetMapping("/loginComplete")
    public String loginComplete(Member member){
        System.out.println("logincomplete");
        return "loginForm";
    }
}
