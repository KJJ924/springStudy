package study.spring.springmvc.service.memberService;

import study.spring.springmvc.dto.member.Member;

import java.util.List;

public interface IMemberService {
    void memberSave(Member member);
    Member getMember(String id);
    List<Member> getMembers();
    void editMember(Member member , String DB_Id);

}
