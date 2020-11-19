package study.spring.springmvc.dao.memberRepository;

import study.spring.springmvc.dto.member.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member getMember(String id);
    List<Member> allMembers();
    Long editMember(Member member,String id);
}
