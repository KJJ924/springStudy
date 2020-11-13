package study.spring.springmvc.controller.MemberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
        return "/Member/signUp/SignUp";
    }

    @PostMapping("/signUpMember")
    public String joinMember(@Validated @ModelAttribute Member member , BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            result.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.getDefaultMessage());
            });
            return "/Member/signUp/SignUp";
        }
        service.memberSave(member);
        attributes.addFlashAttribute("member",member);
        return "redirect:/signUpResult";
    }

    @GetMapping("/signUpResult")
    public String resultPage(){
        return "/Member/signUp/resultSignUp";
    }

}
