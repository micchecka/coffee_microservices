package com.user.jwt_filter;

import com.user.guestservise.GuestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;


@AllArgsConstructor
@Slf4j
public class JwtTokensFilter extends OncePerRequestFilter {
    private final GuestService guestService;

    private String genId(HttpServletResponse response) {
        String guestId = guestService.generateGuestId();
        guestService.saveGuestId(guestId, LocalTime.now().toString());
        response.setHeader("X-Guest-ID", guestId);
        return guestId;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader =(request.getHeader("Authorization"));



        if (authorizationHeader!= null&&  authorizationHeader.startsWith("Bearer")) {
            // TODO: Обработка JWT.
        } else {
            String guestId = (request.getHeader("X-Guest-ID"));
            if (guestId!= null) {
                // Обработка Guest ID.
                String gottenId = (guestService.getGuestData(guestId)); // вернет null, если не найдет в базе
                System.out.println(gottenId);
               // guestService.handleGuestId(guestId);
                if (gottenId == null) {
                    guestService.handleGuestId(genId(response));
                    log.info("ID равен нулл");
                } else {
                    guestService.handleGuestId(guestId);
                   log.info(guestId + "это");
                }
            } else {
                guestService.handleGuestId(genId(response));
            }

        }
        filterChain.doFilter(request, response);
    }
}

