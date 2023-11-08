package com.glauberperez.blog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( auth ->
                    auth.requestMatchers("/register").permitAll() // Rota que não requer autenticação
                    .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin //.loginPage("/login")
                                .permitAll())
                .logout( logout -> logout.permitAll());
        return http.build();
    }
}