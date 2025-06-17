package com.example.demo2.test.repository;


import com.example.demo2.test.domain.Member;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository
{

        private static final Map<Long, Member> store = new HashMap<>();
        private static long sequence = 0L;

        @Override
        public Member save(Member member) {
            long memberId = sequence + 1;
            member.setId(++sequence);
            store.put(member.getId(), member);
            return member;
        }

        @Override
        public Optional<Member> findById(Long id) {
            return Optional.of(store.get(id));
        }

        @Override
        public List<Member> findAll() {
            return new ArrayList<>(store.values());
        }

        @Override
        public Optional<Member> findByName(String name) {
            return store.values() //map values
                    .stream()//java stream function
                    .filter(member -> member.getName().equals(name))
                    .findAny();//get data



        }

    public void clearStore() {
        return;
    }
}


