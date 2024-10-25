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


     public void join(Membership membership){
//        validateDuplicateMembership(membership);
         membershipMapper.save(membership);

     }



    //전체조회
    public List<Membership> findMembership(){
        return membershipMapper.findAll();

    }

}
