package hanuri.website.dao;

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
}
//mybatis 사이트에서 화면 띄웠을때 회원가입하려고 적으면 저장누르면 데이터를 묶어서 db에 저장할떄 연결해주는 프레임워크