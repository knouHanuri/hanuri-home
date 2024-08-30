package hanuri.website.repository;

import hanuri.website.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setId("shchoi");
        member.setName("선화최");
        member.setGender("F");
        member.setPhoneNumber("1234");
        member.setGrade(1);
        repository.save(member);
        Member result = repository.findBySeq(member.getSeq()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findById() {
        Member member1 = new Member();
        member1.setId("shlee");
        member1.setName("상현리");
        member1.setGender("M");
        member1.setPhoneNumber("5678");
        member1.setGrade(3);
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("hljang");
        member2.setName("항렬장");
        member2.setGender("M");
        member2.setPhoneNumber("90");
        member2.setGrade(3);
        repository.save(member2);

        Member member = repository.findById("shlee").get();
        assertThat(member).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setId("hskim");
        member1.setName("형섭킴");
        member1.setGender("M");
        member1.setPhoneNumber("123");
        member1.setGrade(1);
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("jhsong");
        member2.setName("진환송");
        member2.setGender("M");
        member2.setPhoneNumber("456");
        member2.setGrade(3);
        repository.save(member2);

        List<Member> list = repository.findAll();
        assertThat(list.size()).isEqualTo(2);
    }

}
