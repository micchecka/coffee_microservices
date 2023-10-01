package com.user.config;

import com.user.jwt_filter.JwtTokensFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtTokensFilter jwtTokensFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .addFilterBefore(jwtTokensFilter, UsernamePasswordAuthenticationFilter.class)
                ;
    }
}
