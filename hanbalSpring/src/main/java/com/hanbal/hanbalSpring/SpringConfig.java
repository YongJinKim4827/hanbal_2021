package com.hanbal.hanbalSpring;

import com.hanbal.hanbalSpring.repository.MemberRepository;
import com.hanbal.hanbalSpring.repository.MemoryMemberRepository;
import com.hanbal.hanbalSpring.service.MemberService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    
}
