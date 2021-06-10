package com.hanbal.hanbalSpring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import com.hanbal.hanbalSpring.repository.JdbcMemberRepository;
import com.hanbal.hanbalSpring.repository.JdbcTemplateMemberRepository;
import com.hanbal.hanbalSpring.repository.JpaMemberRepository;
import com.hanbal.hanbalSpring.repository.MemberRepository;
import com.hanbal.hanbalSpring.repository.MemoryMemberRepository;
import com.hanbal.hanbalSpring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    // //@Autowired
    // private DataSource dataSource;

   
    // @PersistenceContext
    // private EntityManager em;

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository(){
    //     // return new MemoryMemberRepository();
    //     // return new JdbcMemberRepository(dataSource);
    //     // return new JdbcTemplateMemberRepository(dataSource);
    //     return new JpaMemberRepository(em);
    // }

    
}
