package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findBYName() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("SPRING1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("SPRING2");
        repository.save(member2);

        // when
        Member result = repository.findByName("SPRING1").get();
        assertThat(result).isEqualTo(member1);

        // then


    }

    @Test
    public void findALl() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("SPRING1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("SPRING2");
        repository.save(member2);


        // when
        List<Member> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}
