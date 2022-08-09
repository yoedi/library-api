package com.yoedi.libraryapi.service.impl;

import com.yoedi.libraryapi.model.Buku;
import com.yoedi.libraryapi.model.dto.BukuDTO;
import com.yoedi.libraryapi.model.dto.BukuResponseDTO;
import com.yoedi.libraryapi.model.mapper.BukuMapper;
import com.yoedi.libraryapi.repository.BukuRepository;
import com.yoedi.libraryapi.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    @Autowired
    private BukuMapper bukuMapper;

    public Buku fetchBuku(long id) {
        Buku buku = bukuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Buku tidak ditemukan dengan id "+id));
        return buku;
    }
    @Override
    public BukuResponseDTO save(BukuDTO bukuDTO) {
        Buku buku = bukuMapper.toBuku(bukuDTO);
        bukuRepository.save(buku);
        return bukuMapper.toDTO(buku);
    }

    @Override
    public BukuResponseDTO update(long id, BukuDTO bukuDTO) {
        fetchBuku(id);
        Buku buku = bukuMapper.toBuku(bukuDTO);
        buku.setId(id);

        bukuRepository.save(buku);
        return bukuMapper.toDTO(buku);
    }

    @Override
    public List<BukuResponseDTO> findAll() {
        List<Buku> listBuku = bukuRepository.findAll();
        return bukuMapper.toListDTO(listBuku);
    }

    @Override
    public List<BukuResponseDTO> findByNamaBuku(String namaBuku) {
        List<Buku> listBuku = bukuRepository.findByNamaBukuContainingIgnoreCase(namaBuku);
        return bukuMapper.toListDTO(listBuku);
    }

    @Override
    public String delete(long id) {
        Buku buku = fetchBuku(id);
        bukuRepository.delete(buku);

        return "Success";
    }
}
