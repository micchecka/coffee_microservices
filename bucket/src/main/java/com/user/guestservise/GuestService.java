package com.user.guestservise;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service

@Data
public class GuestService {
    private final StringRedisTemplate redisTemplate;

    @Autowired
    public GuestService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveGuestId(String guestId, String data) {
        redisTemplate.opsForValue().set(guestId, data);
        redisTemplate.expire(guestId, 24, TimeUnit.HOURS);
    }

    public String getGuestData(String guestId) {
        Boolean hasKey = redisTemplate.hasKey(guestId);
        return hasKey ? guestId : null;
    }

    public String generateGuestId() {
        return UUID.randomUUID().toString();
    }

    public void handleGuestId(String guestId) {
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                String.valueOf(guestId), null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_GUEST")));
        SecurityContextHolder.getContext().setAuthentication(upat);

    }

}
