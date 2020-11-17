package study.spring.springmvc.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import study.spring.springmvc.cofig.SessionConfig;
import study.spring.springmvc.dto.beautyShop.BeautyShop;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.service.BeautyShopService.BeautyShopService;
import study.spring.springmvc.service.loginService.ILoginService;
import study.spring.springmvc.service.loginService.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class LoginController {

    ILoginService service;
    BeautyShopService beautyShopService;

    @Autowired
    public LoginController(ILoginService service, BeautyShopService beautyShopService) {
        this.beautyShopService = beautyShopService;
        this.service = service;
    }

    @GetMapping("/")
    public String wellComePage(Model model){
        List<BeautyShop> beautyShops = beautyShopService.getBeautyShops();
        model.addAttribute("shops",beautyShops);
        return "wellComePage";
    }

    @GetMapping("/loginForm")
    public String showLoginForm() {
        return "login/loginForm";
    }

    @PostMapping("/loginPost")
    public String loginValidation(HttpSession session, Member member, HttpServletResponse response) throws IOException {
        Long validation = service.validation(member);
        if (validation!=-1L) {
            SessionConfig.getSessionIdCheck("UserDB_id", String.valueOf(validation));
            System.out.println("성공");
            session.setAttribute("UserDB_id", validation);
            System.out.println(validation);
            return "redirect:/";
        }
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('아이디가 없거나 패스워드가 맞지 않아 로그인에 실패하셨습니다.'); </script>");
        out.flush();
        return "login/loginForm";
    }
//    loginResult 페이지 불필요 할것 같아서 wellcomePage에 통합함.
//    @GetMapping("/loginResult")
//    public String goResultPage(){
//
//        return "/wellComePage";
//    }

    @GetMapping("/logOut")
    public String logOut(HttpSession session){
        session.invalidate();
        return "redirect:/loginForm";
    }
}
