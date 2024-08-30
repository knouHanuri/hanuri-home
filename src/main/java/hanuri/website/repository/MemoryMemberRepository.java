package hanuri.website.repository;

import hanuri.website.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private final static Map<Long, Member> store = new HashMap<>();
    private static Long seq = 0L;

    @Override
    public Member save(Member member) {
        member.setSeq(++seq);
        store.put(member.getSeq(), member);
        return member;
    }

    @Override
    public Optional<Member> findBySeq(Long seq) {
        return Optional.ofNullable(store.get(seq));
    }

    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream()
                .filter(m -> m.getId().equals(id))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
