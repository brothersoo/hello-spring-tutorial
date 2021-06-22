package Brothersoo.hellospringtutorial.service;

import Brothersoo.hellospringtutorial.domain.Member;
import Brothersoo.hellospringtutorial.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach()
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Brothersoo");

        //when
        Long newId = memberService.join(member);

        //then
        assertThat(member.getId()).isEqualTo(newId);
    }

    @Test
    void 회원가입시_이름_중복_예외() {
        //given
        Member member1 = new Member();
        member1.setName("Moistybro");

        Member member2 = new Member();
        member2.setName("Moistybro");

        //when
        memberService.join(member1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
//
    }

    @Test
    void findMembers() {
        //given
        Member member1 = new Member();
        member1.setName("Brothersoo");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("Moistybro");
        memberService.join(member2);

        Member member3 = new Member();
        member3.setName("Joseph");
        memberService.join(member3);

        //when & then
        assertThat(memberService.findMembers().size()).isEqualTo(3);
    }

    @Test
    void findOne() {
        //given
        Member member1 = new Member();
        member1.setName("Brothersoo");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("Moistybro");
        memberService.join(member2);

        //when & then
        assertThat(memberService.findOne(member1.getId()).get()).isEqualTo(member1);
    }
}