package com.example.demo2.test.service;


import com.example.demo2.test.domain.Member;
import com.example.demo2.test.repository.MemberRepository;
import com.example.demo2.test.repository.MemoryMemberRepository;
import com.example.demo2.test.repository.SpringDataJpaMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Memberservice {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final SpringDataJpaMemberRepository memberRepository;

    public Memberservice(SpringDataJpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        Optional<Member> member1 = memberRepository.findByName(member.getName());
        if(member1.isEmpty()){
            memberRepository.save(member);
            return member.getId();
        }else{
          throw new RuntimeException("Member already exists");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMemberById(Long memberid) {
        return memberRepository.findById(memberid);
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> findbyname(long id){
        return memberRepository.findByName(String.valueOf(id));
    }
}