//package com.user.jwt_filter;
//
//import com.user.servise.BucketService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.time.LocalTime;
//
//
//@AllArgsConstructor
//@Slf4j
//public class BucketIdFilter extends OncePerRequestFilter {
//    private final BucketService bucketService;
//
//    private String genId(HttpServletResponse response) {
//        String bucketId = bucketService.generateBucketId();
//        bucketService.saveBucketId(bucketId, LocalTime.now().toString());
//        response.setHeader("Bucket-ID", bucketId);
//        return bucketId;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String bucketId = (request.getHeader("Bucket-ID"));
//        if (bucketId != null) {
//            // Обработка Guest ID.
//            String gottenId = (bucketService.getBucketData(bucketId)); // вернет null, если не найдет в базе
//            System.out.println(gottenId);
//            if (gottenId == null) {
//                genId(response);
//                log.info("ID равен нулл");
//            } else {
//                log.info(bucketId + "это");
//            }
//            filterChain.doFilter(request, response);
//        }
//    }
//}
