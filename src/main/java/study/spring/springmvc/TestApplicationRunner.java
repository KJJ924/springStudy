package study.spring.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import study.spring.springmvc.dao.memberRepository.MemberRepository;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.dto.member.Role;

@Component
public class TestApplicationRunner  implements ApplicationRunner {

    @Autowired
    MemberRepository repository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Member member = new Member("kjj","123","김재준","25", Role.MANAGER);
        Member member1 = new Member("ckr","123","조경록","99",Role.MANAGER);
        repository.save(member);
        repository.save(member1);
    }
}
