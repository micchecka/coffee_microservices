package com.user.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.user.domain.Bucket;
import com.user.domain.BucketResult;
import com.user.servise.BucketService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("api/v1/bucket")
public class BucketController {
    private final BucketService bucketService;

    @GetMapping()
    public ResponseEntity<Bucket> getBucketId(@RequestHeader HttpHeaders headers) throws JsonProcessingException {
//        HttpHeaders newHttpHeader = new HttpHeaders();
   BucketResult result = bucketService.getBucketData(headers);
//
//        if (result.isNewIdCreated()) {
//            newHttpHeader.add("Bucket-ID", result.getBucket().getBucketId().toString());
//        }
        return new ResponseEntity<Bucket>(result.getBucket(), HttpStatus.OK);
    }

}

