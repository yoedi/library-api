package com.yoedi.libraryapi.service.impl;

import com.yoedi.libraryapi.model.Peminjaman;
import com.yoedi.libraryapi.model.dto.PeminjamanDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanResponseDTO;
import com.yoedi.libraryapi.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private
    @Override
    public PeminjamanResponseDTO save(PeminjamanDTO peminjamanDTO) {
        return null;
    }

    @Override
    public PeminjamanResponseDTO update(long id, PeminjamanDTO peminjamanDTO) {
        return null;
    }

    @Override
    public Peminjaman fetchPeminjaman(long id) {
        return null;
    }

    @Override
    public List<PeminjamanResponseDTO> findAll() {
        return null;
    }

    @Override
    public List<PeminjamanResponseDTO> findByIdUser(long idUser) {
        return null;
    }

    @Override
    public String delete(long id) {
        return null;
    }
}
