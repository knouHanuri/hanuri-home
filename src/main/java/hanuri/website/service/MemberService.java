package hanuri.website.service;

import hanuri.website.dao.MemberMapper;
import hanuri.website.domain.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    /*
     * 저장
     * */
    public void join(Member member) {
        //중복 회원 확인
        validateDuplicateMember(member);
        memberMapper.save(member);
        //return member.getSeq();
    }

    private void validateDuplicateMember(Member member) {
        memberMapper.findById(member.getMemberId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
     * 전체 조회
     * */
    public List<Member> findMembers() {
        return memberMapper.findAll();
    }

    /*
     * ID로 조회
     * */
    public Optional<Member> findOne(int memberId) {
        return memberMapper.findById(memberId);
    }

    public void modify(Member member) {
        memberMapper.modify(member);
    }

    public Optional<Member> findByProviderInfo(String provider, String providerId) {
        return memberMapper.findByProviderAndProviderId(provider,providerId);
    }
}
