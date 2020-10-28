package study.spring.springmvc.service.memberService;

import study.spring.springmvc.dto.member.Member;

import java.util.List;

public interface IMemberService {
    void memberSave(Member member);
    Member getMember(Long id);
    List<Member> getMembers();
    void editMember(Member member , Long DB_Id);

}
