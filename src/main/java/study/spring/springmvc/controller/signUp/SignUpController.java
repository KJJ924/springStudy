package study.spring.springmvc.controller.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.service.memberService.MemberService;

@Controller
public class SignUpController {
    MemberService service;

    @Autowired
    public SignUpController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/signUp")
    public String showSignUpPage(){
        return "/signUp/SignUp";
    }
    @PostMapping("/signUpMember")
    public String joinMember(@ModelAttribute Member member , RedirectAttributes attributes){
        service.memberSave(member);
        attributes.addFlashAttribute("member",member);
        return "redirect:/signUpResult";
    }

    @GetMapping("/signUpResult")
    public String resultPage(){
        return "/signUp/resultSignUp";
    }

}
