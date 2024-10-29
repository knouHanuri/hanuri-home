package hanuri.website.service;

import hanuri.website.dao.MembershipMapper;
import hanuri.website.dto.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    private final MembershipMapper membershipMapper;

    @Autowired
    public MembershipService(MembershipMapper membershipMapper){this.membershipMapper = membershipMapper;}

    //회비납부내역입력
     public void save(Membership membership){
//        validateDuplicateMembership(membership);
         membershipMapper.save(membership);

     }
     //회비납부내역입력 버튼
    public List<Membership> findAllMembers() {
        return membershipMapper.findAllMembers();
    }
    //전체조회
    public List<Membership> findMembership(){
        return membershipMapper.findAll();
    }
    //회비납부내역 수정
    public void modify(Membership membership){
        membershipMapper.modify(membership);
    }
    //회비납부내역 삭제
    public void delete(Membership membership){
        membershipMapper.delete(membership);
    }
}
