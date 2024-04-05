package hello.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    void memberTest() {
        Member member = new Member("idA", "memberA");
        memberRepository.initTable();
        memberRepository.saveMember(member);
        Member findMember = memberRepository.findMember(member.getMemberId());
        assertThat(findMember.getName()).isEqualTo(member.getName());
        assertThat(findMember.getMemberId()).isEqualTo(member.getMemberId() );
    }
}


