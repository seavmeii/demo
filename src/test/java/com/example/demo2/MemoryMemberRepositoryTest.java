package com.example.demo2;

import com.example.demo2.test.domain.Member;
import com.example.demo2.test.repository.MemoryMemberRepository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        this.repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");
        this.repository.save(member);
        Member result = (Member) this.repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        this.repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        this.repository.save(member2);
        Member result = (Member) this.repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        this.repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        this.repository.save(member2);
        List<Member> result = this.repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}



