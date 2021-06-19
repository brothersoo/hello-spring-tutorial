package Brothersoo.hellospringtutorial.repository;

import Brothersoo.hellospringtutorial.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Brothersoo");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("Brothersoo");

        repository.save(member);

        Member result = repository.findByName("Brothersoo").get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Brothersoo");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Moistybro");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
