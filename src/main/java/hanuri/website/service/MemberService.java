package hanuri.website.service;

import hanuri.website.domain.Member;
import hanuri.website.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    * 회원가입
    * */
    public Long join(Member member)
    {
        validateDupMember(member);
        memberRepository.save(member);
        return member.getSeq();
    }

    private void validateDupMember(Member member){
        memberRepository.findById(member.getId())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 등록된 ID 입니다.");
                });
    }

    /*
    * 전체 회원 조회
    * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    /*
    * 회원 조회
    * */
    public Optional<Member> findOne(Long memberSeq){
        return memberRepository.findBySeq(memberSeq);
    }
}
