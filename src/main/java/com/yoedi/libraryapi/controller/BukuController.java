package com.yoedi.libraryapi.controller;

import com.yoedi.libraryapi.helper.ResponseHandler;
import com.yoedi.libraryapi.model.dto.BukuDTO;
import com.yoedi.libraryapi.model.dto.BukuResponseDTO;
import com.yoedi.libraryapi.repository.BukuRepository;
import com.yoedi.libraryapi.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buku")
public class BukuController {

    @Autowired
    private BukuService bukuService;

    @PostMapping
    public ResponseEntity saveBuku(@RequestBody BukuDTO bukuDTO) {
        BukuResponseDTO bukuResponseDTO = bukuService.save(bukuDTO);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, bukuResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBuku(@PathVariable("id") long id,
                                     @RequestBody BukuDTO bukuDTO) {
        BukuResponseDTO bukuResponseDTO = bukuService.update(id, bukuDTO);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, bukuResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity getBuku(@RequestParam String nama) {
        List<BukuResponseDTO> listBuku = bukuService.findAll();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, listBuku);
    }

    @GetMapping
    public ResponseEntity getBukuByName(@RequestParam String nama) {
        List<BukuResponseDTO> listBuku = bukuService.findByNamaBuku(nama);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, listBuku);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBuku(@PathVariable("id") long id) {
        String status = bukuService.delete(id);
        return ResponseHandler.generateResponse(status, HttpStatus.OK, null);
    }
}
