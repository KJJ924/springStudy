package study.spring.springmvc.service.memberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.spring.springmvc.dao.memberRepository.MemberRepository;
import study.spring.springmvc.dto.member.Member;

import java.util.List;

@Service
public class MemberService implements IMemberService{
    MemberRepository repository;

    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void memberSave(Member member) {
        repository.save(member);
    }

    @Override
    public Member getMember(String id) {
        Member member = repository.getMember(id);
        if(member==null){
            System.out.println("해당하는 Member가 없습니다.");
        }
        return member;
    }

    @Override
    public List<Member> getMembers() {
        return repository.allMembers();
    }

    @Override
    public void editMember(Member member, String DB_Id) {
        if(member.getName() !=null && member.getDB_ID() !=null && member.getId() !=null){
            repository.editMember(member,DB_Id);
        }
        else
            System.out.println("edit 실패 ");
    }
}
