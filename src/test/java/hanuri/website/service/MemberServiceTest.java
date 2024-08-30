package hanuri.website.service;

import hanuri.website.domain.Member;
import hanuri.website.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입(){
        //given
        Member member = new Member();
        member.setId("ghno");
        member.setName("건호노");
        member.setGender("M");
        member.setPhoneNumber("1234");
        member.setGrade(1);

        //when
        Long savedSeq = memberService.join(member);

        //then
        Member findedMember = memberService.findOne(savedSeq).get();
        assertThat(findedMember.getId()).isEqualTo(member.getId());

    }

    @Test
    void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setId("mychoi");
        member1.setName("미영최");
        member1.setGender("F");
        member1.setPhoneNumber("1234");
        member1.setGrade(3);

        Member member2 = new Member();
        member2.setId("mychoi");
        member2.setName("미영최");
        member2.setGender("F");
        member2.setPhoneNumber("1234");
        member2.setGrade(3);

        //when
        memberService.join(member1);

        //then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }

}
