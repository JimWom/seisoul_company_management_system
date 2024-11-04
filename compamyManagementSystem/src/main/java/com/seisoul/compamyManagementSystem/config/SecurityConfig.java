package com.seisoul.compamyManagementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // 根据需求可以启用
                .authorizeHttpRequests()
                .requestMatchers("/login", "/css/**", "/img/**").permitAll()  // 允许匿名访问登录页面和静态资源
                .anyRequest().authenticated()  // 其他所有请求需要认证
                .and()
                .formLogin()
                .loginPage("/login")  // 自定义登录页面
                .loginProcessingUrl("/verify")  // 处理登录表单提交的路径
                .defaultSuccessUrl("/home", true)  // 登录成功后跳转的页面
                .permitAll()  // 允许所有人访问登录相关页面
                .and()
                .logout()
                .permitAll();  // 允许登出
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // 使用内存中的用户存储来验证用户
        return new InMemoryUserDetailsManager(
                User.withUsername("wangzheng")
                        .password(passwordEncoder.encode("1234"))
                        .roles("USER")
                        .build(),
                        User.withUsername("admin")
                        .password(passwordEncoder.encode("1234"))
                        .roles("USER")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
