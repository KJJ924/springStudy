package study.spring.springmvc.controller.MemberController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import study.spring.springmvc.dao.memberRepository.MemberRepository;
import study.spring.springmvc.dto.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SignUpControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MemberRepository repository;
    @Test
    void 회원가입테스트() throws Exception {
        mockMvc.perform(post("/signUpMember")
                .param("name","JaeJoon")
                .param("id","kjj")
                .param("age","25")
                .param("pw","123"))
        .andDo(print())
        .andExpect(redirectedUrl("/signUpResult"));
        Member member = repository.getMember(1L);
        assertThat(member.getName()).isEqualTo("JaeJoon");
    }

    @Test
    void 회원데이터검증() throws Exception {
        /**
         * 회원 검증
         * age = notNull && notEmpty && 0 < value
         * id,pw,name = notNull && notEmpty
         */
        mockMvc.perform(post("/signUpMember")
                .param("name","")
                .param("id","kjj")
                .param("age","-1")
                .param("pw","123"))
        .andDo(print())
        .andExpect(model().hasErrors());
    }


}