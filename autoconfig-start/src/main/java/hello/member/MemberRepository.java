package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate template;

    public MemberRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void initTable() {
        template.execute("create table member(member_id char(20) primary key, name char(20))");
    }

    public void saveMember(Member member) {
        template.update("insert into member(member_id, name) values (?,?)"
                , member.getMemberId()
                , member.getName());
    }

    public Member findMember(String memberId) {
        return template.queryForObject("select * from member where member_id = ?"
                , BeanPropertyRowMapper.newInstance(Member.class)
                , memberId
        );
    }

    List<Member> findMemberAll() {
        return template.query("select * from member"
                , BeanPropertyRowMapper.newInstance(Member.class)
        );
    }

}
