package hanuri.website.dao;

import hanuri.website.domain.dto.Login.LoginRequest;
import hanuri.website.domain.dto.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    void save(Member member);

    Optional<Member> findById(int memberId);

    Optional<Member> findByUserName(String username);

    List<Member> findAll();

    void modify(Member member);

    public Member login(LoginRequest loginRequest);
}
