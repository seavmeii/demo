package com.example.demo2.test.repository;

import com.example.demo2.test.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {

        Optional<Member> findByName(String name);
    }
