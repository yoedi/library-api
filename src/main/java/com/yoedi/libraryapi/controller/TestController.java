package com.yoedi.libraryapi.controller;

import com.yoedi.libraryapi.model.dto.BukuResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public ResponseEntity test() {
        BukuResponseDTO b = BukuResponseDTO.builder()
                .id(1)
                .category("Inggris")
                .namaBuku("Belajar Bahasa Inggris")
                .build();
        Integer a = Integer.parseInt("s");
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }
}
