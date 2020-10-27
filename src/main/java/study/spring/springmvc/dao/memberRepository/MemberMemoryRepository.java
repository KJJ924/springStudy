package study.spring.springmvc.dao.memberRepository;

import org.springframework.stereotype.Repository;
import study.spring.springmvc.dto.member.Member;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberMemoryRepository implements MemberRepository {
    private static final Map<Long, Member> memberRepository = new ConcurrentHashMap<>();

    private Long GEN_ID = 1L;

    @Override
    public void save(Member member) {
        member.setDB_ID(GEN_ID);
        memberRepository.put(GEN_ID, member);
        GEN_ID++;
    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.get(id);
    }

    @Override
    public List<Member> allMembers() {
        Set<Long> keys = memberRepository.keySet();
        List<Member> members = new ArrayList<>();
        keys.forEach(key -> members.add(memberRepository.get(key)));
        return members;
    }
}
