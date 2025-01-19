package hanuri.website.dao;

import hanuri.website.dto.Membership;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MembershipMapper {
    void save(Membership membership);
    Optional<Membership> findBymember_id(int member_id);
    Optional<Membership> findBypayment_date(Date payment_date);
    Optional<Membership> findByamount(int amount);
    Optional<Membership> findBygetexpiration_date(Date expiration_date);
    List<Membership> findAll();
}
