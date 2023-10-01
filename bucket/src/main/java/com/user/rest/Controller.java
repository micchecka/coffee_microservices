package com.user.rest;

import com.user.guestservise.GuestService;
import com.user.jwt_filter.JwtTokensFilter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/firstAuth")
public class Controller {

    private final RestTemplate restTemplate;

    @GetMapping()
    public ResponseEntity<String> getGuestIorToken(HttpServletRequest request) {
        String principal = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null && !principal.startsWith("Bearer")) {

            return ResponseEntity.ok(principal);  // Вернуть гостевой ID

        } else {
            String token = request.getHeader("Authorization");
            if (token != null && !token.isEmpty()) {
                return ResponseEntity.ok(token);  // Вернуть JWT, если он есть
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No JWT or Guest ID found");
            }
        }

//        String callbackUrl = "http://api-gateway/callback-endpoint";
//        restTemplate.postForEntity("http://menu-service/get-menu?callback=" + callbackUrl, requestEntity, Void.class);
//
    }
}
