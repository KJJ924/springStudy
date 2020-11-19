package study.spring.springmvc.controller.MemberController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.service.memberService.MemberService;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class editControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    MemberService service;

    private MockHttpSession session;
    @BeforeEach
    void setSession(){
        session = new MockHttpSession();
        session.setAttribute("UserDB_id","kjj924");
    }

/*
    @Test
    void 회원정보수정테스트() throws Exception {
        Member member = new Member("kjj924","1234","JaeJoon","25");
        service.memberSave(member);
        mockMvc.perform(post("/editMember")
                .session(session)
                .param("pw","1"))
                .andDo(print())
                .andExpect(status().isOk());

        Member editMember = service.getMember("kjj924");
        assertThat(editMember.getPw()).isEqualTo("1");
    }

 */
}
