package com.user.servise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.domain.Bucket;
import com.user.domain.BucketResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Data
@AllArgsConstructor
public class BucketService {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public UUID generateId() {
        return UUID.randomUUID();
    }

    public void saveBucket(Bucket bucket) {
        String bucketId = bucket.getBucketId().toString();
        try {
            String bucketData = objectMapper.writeValueAsString(bucket);
            redisTemplate.opsForValue().set(bucketId, bucketData);
            redisTemplate.expire(bucketId, 24, TimeUnit.HOURS);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

        private Bucket generateIdAndSaveBucket(HttpHeaders headers) {
        UUID bucketId = generateId();
        Bucket bucket = new Bucket();
        bucket.setBucketId(bucketId);
        saveBucket(bucket);
        return bucket;
    }


    public BucketResult getBucketData(HttpHeaders headers) throws JsonProcessingException {
        BucketResult result = new BucketResult();
        String bucketIdFromRequest = headers.getFirst("Bucket-ID");
        UUID bucketId;

        if (bucketIdFromRequest != null) {
            Boolean hasKey = redisTemplate.hasKey(bucketIdFromRequest);
            if (hasKey != null && hasKey) {
                bucketId = UUID.fromString(bucketIdFromRequest);
                result.setNewIdCreated(false);
            } else {
                bucketId = generateIdAndSaveBucket(headers).getBucketId();
                result.setNewIdCreated(true);
            }
        } else {
            bucketId = generateIdAndSaveBucket(headers).getBucketId();
            result.setNewIdCreated(true);
        }

        Bucket bucket = objectMapper.readValue(redisTemplate.opsForValue().get(bucketId.toString()), Bucket.class);
        result.setBucket(bucket);

        return result;
    }



}


