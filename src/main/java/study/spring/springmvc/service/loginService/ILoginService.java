package study.spring.springmvc.service.loginService;

import study.spring.springmvc.dto.member.Member;

public interface ILoginService {
    Long validation(Member member);
}
