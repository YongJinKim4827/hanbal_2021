package com.hanbal.hanbalSpring;

import javax.sql.DataSource;

import com.hanbal.hanbalSpring.repository.JdbcMemberRepository;
import com.hanbal.hanbalSpring.repository.MemberRepository;
import com.hanbal.hanbalSpring.repository.MemoryMemberRepository;
import com.hanbal.hanbalSpring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    
    //@Autowired
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

    
}
