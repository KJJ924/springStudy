package study.spring.springmvc.dao.memberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import study.spring.springmvc.dto.member.Member;
import study.spring.springmvc.dto.member.Role;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class MemberJdbcRepository implements  MemberRepository {

    private final JdbcTemplate template;

    @Autowired
    public MemberJdbcRepository(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Member member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(template);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("db_id");

        Map<String,Object> parameters = new HashMap<>();
        parameters.put("id",member.getId());
        parameters.put("pw",member.getPw());
        parameters.put("name",member.getName());
        parameters.put("age",member.getAge());
        parameters.put("role",member.getRole());

       jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    }

    @Override
    public Member getMember(String id) {
        System.out.println(id);
        List<Member> query = template.query("select * from member where id = ?", memberRowMapper(),id);
        // findAny 리턴 타입 Optional 로 리턴하는 게 안전하긴함 -> NULL 값 리턴할 수 도 있어서.
        return query.stream().findAny().get();
    }

    @Override
    public List<Member> allMembers() {
        return template.query("select *from member", memberRowMapper());
    }

    @Override
    public Long editMember(Member member, String id) {
        return Long.valueOf(template.update("update Member set pw = ? where id = ?", member.getPw(), id));
    }

    private RowMapper<Member> memberRowMapper(){
        return (resultSet, i) -> {
            Member member = new Member();
            member.setDB_ID(resultSet.getLong("DB_ID"));
            member.setId(resultSet.getString("ID"));
            member.setPw(resultSet.getString("PW"));
            member.setName(resultSet.getString("NAME"));
            member.setAge(resultSet.getString("AGE"));
            String role = resultSet.getString("role");
            member.setRole(Role.valueOf(role));
            return member;
        };
    }
}
