package com.yoedi.libraryapi.service;

import com.yoedi.libraryapi.model.Buku;
import com.yoedi.libraryapi.model.dto.BukuDTO;
import com.yoedi.libraryapi.model.dto.BukuResponseDTO;

import java.util.List;

public interface BukuService {

    BukuResponseDTO save(BukuDTO bukuDTO);
    BukuResponseDTO update(long id, BukuDTO bukuDTO);

    Buku fetchBuku(long id);
    List<BukuResponseDTO> findAll();

    List<BukuResponseDTO> findByNamaBuku(String namaBuku);
    String delete(long id);

}
