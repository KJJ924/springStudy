package study.spring.springmvc.dao.memberRepository;

import org.junit.jupiter.api.Test;
import study.spring.springmvc.dto.member.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class MemberMemoryRepositoryTest {
    MemberRepository repository = new MemberMemoryRepository();

    @Test
    void save_and_getMember() {
        //given
        Member member = new Member();
        member.setName("Jae Joon");
        //when
        repository.save(member);
        //then
        Member getMember = repository.getMember(1L);
        assertThat(member).isEqualTo(getMember);
    }

    @Test
    void allMembers() {
        //given
        Member member = new Member();
        Member member2 = new Member();
        repository.save(member);
        repository.save(member2);
        //when
        List<Member> members = repository.allMembers();
        //then
        assertThat(members.get(0)).isEqualTo(member);
        assertThat(members.get(1)).isEqualTo(member2);
    }
}