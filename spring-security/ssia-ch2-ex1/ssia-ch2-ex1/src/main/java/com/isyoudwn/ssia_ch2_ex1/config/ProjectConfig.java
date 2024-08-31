package com.isyoudwn.ssia_ch2_ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    /**
     * TODO :
     * 1. 자격 증명이 있는 사용자를 하나 이상 만든다
     * 2. 사용자를 UserDetailsService에서 관리하도록 추가한다.
     * 3. 주어진 암호를 UserDetailsService가 저장하고 관리하는 암호를 이용해 검증하는
     * PasswordEncoder 형식의 빈을 정의한다.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        userDetailsService.createUser(user);

        return userDetailsService;
    }




}
