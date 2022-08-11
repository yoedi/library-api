package com.yoedi.libraryapi.service;

import com.yoedi.libraryapi.model.Buku;
import com.yoedi.libraryapi.model.Peminjaman;
import com.yoedi.libraryapi.model.dto.BukuDTO;
import com.yoedi.libraryapi.model.dto.BukuResponseDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanResponseDTO;

import java.util.List;

public interface PeminjamanService {

    PeminjamanResponseDTO save(PeminjamanDTO peminjamanDTO);
    PeminjamanResponseDTO update(long id, PeminjamanDTO peminjamanDTO);
    Peminjaman fetchPeminjaman(long id);
    List<PeminjamanResponseDTO> findAll();
    List<PeminjamanResponseDTO> findByIdUser(long idUser);
    String delete(long id);
}
