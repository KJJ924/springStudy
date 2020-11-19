package study.spring.springmvc.controller.MemberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.service.memberService.MemberService;

import javax.servlet.http.HttpSession;

@Controller
public class editController {
    MemberService service;

    @Autowired
    public editController(MemberService service) {
        this.service = service;
    }

    @GetMapping("/memberEdit")
    public String showEditPage(@SessionAttribute("UserDB_id") String DB_id , Model model){
//        Long DB_id = (Long) session.getAttribute("UserDB_id");
        Member member = service.getMember(DB_id);
        model.addAttribute("member",member);
        return "/Member/edit/MemberDetailPage";
    }

    @PostMapping("/editMember")
    public String editMember(@RequestParam String pw, @SessionAttribute("UserDB_id") String DB_id){
//        Long DB_id = (Long) session.getAttribute("UserDB_id");
        Member member = service.getMember(DB_id);
        member.setPw(pw);
        service.editMember(member,DB_id);
        return "wellComePage";
    }

}
