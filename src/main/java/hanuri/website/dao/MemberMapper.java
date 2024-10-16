package hanuri.website.dao;

import hanuri.website.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(Member member);
    Optional<Member> findBySeq(Long seq);
    Optional<Member> findById(String id);
    List<Member> findAll();
}
