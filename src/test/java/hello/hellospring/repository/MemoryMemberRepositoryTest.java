package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository  repository = new MemoryMemberRepository();

    @AfterEach // 테스트가 끝날때마다 repository를 깔끔하게 지워주는 코드
    public void afterEach() {
        repository.clearStore();
    }

    @Test // Test를 실핼할 수 있게 해준다.
    public void sava() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift F6하면 한번에 이름 수정 가능
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();//option + commend + v = 생성자 생성

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
