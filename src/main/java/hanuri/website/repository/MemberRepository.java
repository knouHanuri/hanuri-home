package hanuri.website.repository;

import hanuri.website.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findBySeq(Long seq);
    Optional<Member> findById(String id);
    List<Member> findAll();
}
