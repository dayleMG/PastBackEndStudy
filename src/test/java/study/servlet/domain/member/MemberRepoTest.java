package study.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepoTest {

    //스프링을 안쓰기 떄문에 사용하는 방식
    MemberRepo memberRepo = MemberRepo.getInstance();

    //테스트가 끝나면
    @AfterEach
    void afterEach() {
        memberRepo.clearStore();
    }

    @Test
    void save() {

        //given
        Member member = new Member("kim", 28);

        //when
        Member savedMember = memberRepo.save(member);

        //then
        Member memberId = memberRepo.findById(member.getId());
        assertThat(memberId).isEqualTo(savedMember);

    }

    @Test
    void findAll() {

        //given
        Member member1 = new Member("kim", 28);
        Member member2 = new Member("park", 27);

        //when
        memberRepo.save(member1);
        memberRepo.save(member2);
        List<Member> result = memberRepo.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);

    }


}