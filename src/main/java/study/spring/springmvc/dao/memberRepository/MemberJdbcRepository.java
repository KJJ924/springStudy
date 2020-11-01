package study.spring.springmvc.dao.memberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import study.spring.springmvc.dto.member.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Primary
public class MemberJdbcRepository implements  MemberRepository {

    private JdbcTemplate template;

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

        Number number = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    }

    @Override
    public Member getMember(Long id) {
        System.out.println(id);
        List<Member> query = template.query("select * from member where db_id = ?", memberRowMapper(),id);
        Member member = query.stream().findAny().get();
        return member;
    }

    @Override
    public List<Member> allMembers() {
        List<Member> memberList = template.query("select *from member", memberRowMapper());
        return memberList;
    }

    @Override
    public Long editMember(Member member, Long id) {
        template.update("update Member set pw = ? where DB_Id = ?", member.getPw(), id);
        return id;
    }

    private RowMapper<Member> memberRowMapper(){
        return (resultSet, i) -> {
            Member member = new Member();
            member.setDB_ID(resultSet.getLong("DB_ID"));
            member.setId(resultSet.getString("ID"));
            member.setPw(resultSet.getString("PW"));
            member.setName(resultSet.getString("NAME"));
            member.setAge(resultSet.getString("AGE"));
            return member;
        };
    }
}
