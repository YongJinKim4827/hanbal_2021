package com.hanbal.hanbalSpring.repository;


import java.util.Optional;

import com.hanbal.hanbalSpring.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{

        @Override
        Optional<Member> findByName(String name);
}
