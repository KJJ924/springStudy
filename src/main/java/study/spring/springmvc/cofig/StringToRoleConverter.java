package study.spring.springmvc.cofig;

import org.springframework.core.convert.converter.Converter;
import study.spring.springmvc.dto.member.Role;

public class StringToRoleConverter  implements Converter<String,Role> {
    @Override
    public Role convert(String s) {
        return Role.valueOf(s);
    }
}
