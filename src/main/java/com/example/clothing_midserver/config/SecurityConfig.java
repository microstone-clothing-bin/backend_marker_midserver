// 로그인 비활성화 (API, 혹은 내부용 서버 로그인 무시하는 용도)

package com.example.clothing_midserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                // 모든 요청에 대해 인증 없이 허용 (모든 URL 접근 가능)

                .csrf(csrf -> csrf.disable())
                // CSRF 보호 기능 비활성화 (주로 REST API에서 비활성화함)

                .formLogin(form -> form.disable());
        // 기본 제공되는 로그인 폼 비활성화 (로그인 페이지 아예 없음)

        return http.build(); // 설정한 내용을 기반으로 SecurityFilterChain 객체 생성 및 반환
    }
}