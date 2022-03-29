package com.genug.spring.training.jwt.controller;

import com.genug.jwt.model.dto.MessageDto;
import com.genug.jwt.security.TokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<?> test() {
        log.info("test --- called");
        return ResponseEntity.ok().build();
    }

}
