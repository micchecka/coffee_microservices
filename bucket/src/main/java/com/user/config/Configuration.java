package com.user.config;

import com.user.guestservise.GuestService;
import com.user.jwt_filter.JwtTokensFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Autowired
    private GuestService guestService;
    @Bean
    public JwtTokensFilter jwtTokensFilter() {
        return new JwtTokensFilter(guestService);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
