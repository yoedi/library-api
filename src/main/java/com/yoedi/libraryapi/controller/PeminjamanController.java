package com.yoedi.libraryapi.controller;

import com.yoedi.libraryapi.helper.ResponseHandler;
import com.yoedi.libraryapi.model.Peminjaman;
import com.yoedi.libraryapi.model.dto.BukuResponseDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanResponseDTO;
import com.yoedi.libraryapi.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("peminjaman")
public class PeminjamanController {

    @Autowired
    private PeminjamanService peminjamanService;

    @PostMapping
    public ResponseEntity savePeminjaman(@RequestBody PeminjamanDTO peminjamanDTO) {
        PeminjamanResponseDTO peminjamanResponseDTO = peminjamanService.save(peminjamanDTO);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, peminjamanResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePeminjaman(@PathVariable("id") long id,
                                           @RequestBody PeminjamanDTO peminjamanDTO) {
        PeminjamanResponseDTO peminjamanResponseDTO = peminjamanService.update(id, peminjamanDTO);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, peminjamanResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity getPeminjaman() {
        List<PeminjamanResponseDTO> listPeminjaman = peminjamanService.findAll();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, listPeminjaman);
    }

    @GetMapping
    public ResponseEntity getPeminjamanByIdUser(@RequestParam long idUser) {
        List<PeminjamanResponseDTO> listPeminjaman = peminjamanService.findByIdUser(idUser);
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, listPeminjaman);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePeminjaman(@PathVariable("id") long id) {
        String status = peminjamanService.delete(id);
        return ResponseHandler.generateResponse(status, HttpStatus.OK, null);
    }
}
