package hanuri.website.service;

import hanuri.website.dao.MemberMapper;
import hanuri.website.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void join(Member member){
        //중복 회원 확인
        validateDuplicateMember(member);
        memberMapper.save(member);
        //return member.getSeq();
    }

    private void validateDuplicateMember(Member member){
        memberMapper.findById(member.getId())
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
}
