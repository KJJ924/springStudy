package study.spring.springmvc.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.spring.springmvc.cofig.SessionConfig;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.service.loginService.ILoginService;
import study.spring.springmvc.service.loginService.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Controller
public class LoginController {

    ILoginService service;

    @Autowired
    public LoginController(ILoginService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String wellComePage(){
        return "wellComePage";
    }

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "login/loginForm";
    }

    @PostMapping("/loginPost")
    public String loginValidation(HttpSession session, Member member){
        Long validation = service.validation(member);
        if (validation!=-1L) {
            SessionConfig.getSessionIdCheck("UserDB_id", String.valueOf(validation));
            System.out.println("성공");
            session.setAttribute("UserDB_id", validation);
            System.out.println(validation);
            return "redirect:/loginResult";
        }
        return "redirect:/loginResult";
    }
    @GetMapping("/loginResult")
    public String goResultPage(){
        return "login/loginResult";
    }
    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/loginForm";
    }
}
