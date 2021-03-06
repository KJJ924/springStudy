package study.spring.springmvc.service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.springmvc.dao.memberRepository.MemberRepository;
import study.spring.springmvc.dto.member.Member;

import java.util.List;

@Service
public class LoginService implements ILoginService{
    MemberRepository repository;

    @Autowired
    public LoginService(MemberRepository repository) {
        this.repository = repository;
    }


    @Override
    public String validation(Member member) {
        List<Member> members = repository.allMembers();
        for (Member member1: members) {
            if (member1.getId().equals(member.getId())) {
                System.out.println("id통과");
                if (member1.getPw().equals(member.getPw())) {
                    System.out.println("pw통과");
                    return member1.getId();
                }
            }
        }
        return "false";
    }
}
