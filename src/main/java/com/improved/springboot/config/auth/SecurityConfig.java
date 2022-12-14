package com.improved.springboot.config.auth;

import com.improved.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()//DBConsole화면 사용가능
                .and()
                .authorizeRequests()//URL별 권한 관리 설정 옵션의 시작점
                .antMatchers("/","/css/**","/images/**",
                        "/js/**","/mysql/**").permitAll().antMatchers("/api/v1/**")
                .hasRole(Role.USER.name()).anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/").and().oauth2Login()
                .userInfoEndpoint().userService(customOAuth2UserService);
    }
}
