package hanuri.website.dao;

import hanuri.website.dto.Membership;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface MembershipMapper {
    void save(Membership membership);
    List<Membership> findAll();
    List<Membership> findAllMembers();
    void modify(Membership membership);
    void delete(Membership membership);
}
