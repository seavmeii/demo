package com.example.demo2;

import com.example.demo2.test.domain.Member;
import com.example.demo2.test.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import com.example.demo2.test.service.Memberservice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemberServiceTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @Autowired
    Memberservice memberService; //  = new Memberservice();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void MemberNameCheck() {
        // given
        Member member1 = new Member();
        member1.setName("member1");
        Member member2 = new Member();
        member2.setName("member1");


        // when
        try {
            memberService.join(member1);

            memberService.join(member2);


            // then
//       memberService.findbyname(member1.getId());
            int membercount = memberService.findMembers().size();

            assertThat(member1.getName()).isEqualTo(membercount).isEqualTo(2);

        } catch (Exception e) {

            assertThat(e).isNotNull();
        }
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");
    }


    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring");
        memberService.join(member1);
        Member member2 = new Member();
        member2.setName("spring");
        memberService.join(member2);

        //
        List<Member> list = repository.findAll();
        int memberServiceSize = list.size();
        //
        assertThat(memberServiceSize).isEqualTo(2);
    }

    @Test
    void findMemberById() {
        Member member1 = new Member();
        member1.setName("Member1");
        memberService.join(member1);

        Long memberid;
        Member member = memberService.findMemberById(1L).get();
        assertThat(member.getName()).isEqualTo("Member1");


    }

}


