package com.yoedi.libraryapi.service.impl;

import com.yoedi.libraryapi.model.Peminjaman;
import com.yoedi.libraryapi.model.dto.PeminjamanDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanResponseDTO;
import com.yoedi.libraryapi.model.mapper.PeminjamanMapper;
import com.yoedi.libraryapi.repository.PeminjamanRepository;
import com.yoedi.libraryapi.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private PeminjamanMapper peminjamanMapper;

    @Override
    public PeminjamanResponseDTO save(PeminjamanDTO peminjamanDTO) {
        Peminjaman peminjaman = peminjamanMapper.toPeminjaman(peminjamanDTO);
        peminjamanRepository.save(peminjaman);

        return peminjamanMapper.toDTO(peminjaman);
    }

    @Override
    public PeminjamanResponseDTO update(long id, PeminjamanDTO peminjamanDTO) {
        fetchPeminjaman(id);
        Peminjaman peminjaman = peminjamanMapper.toPeminjaman(peminjamanDTO);

        peminjaman.setId(id);
        peminjamanRepository.save(peminjaman);

        return peminjamanMapper.toDTO(peminjaman);
    }

    @Override
    public Peminjaman fetchPeminjaman(long id) {
        Peminjaman peminjaman = peminjamanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Peminjaman tidak ditemukan dengan id "+id));

        return peminjaman;
    }

    @Override
    public List<PeminjamanResponseDTO> findAll() {
        List<Peminjaman> listPeminjaman = peminjamanRepository.findAll();
        return peminjamanMapper.toListDTO(listPeminjaman);
    }

    @Override
    public List<PeminjamanResponseDTO> findByIdUser(long idUser) {
        List<Peminjaman> listPeminjaman = peminjamanRepository.findByIdUser(idUser);
        return peminjamanMapper.toListDTO(listPeminjaman);
    }

    @Override
    public String delete(long id) {
        Peminjaman peminjaman = fetchPeminjaman(id);
        peminjamanRepository.delete(peminjaman);

        return "Success";
    }
}
