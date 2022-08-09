package com.yoedi.libraryapi.model.mapper;

import com.yoedi.libraryapi.model.Buku;
import com.yoedi.libraryapi.model.dto.BukuDTO;
import com.yoedi.libraryapi.model.dto.BukuResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BukuMapper {

    public Buku toBuku(BukuDTO bukuDTO) {
        return Buku.builder()
                .namaBuku(bukuDTO.getNamaBuku())
                .category(bukuDTO.getCategory())
                .build();
    }

    public BukuResponseDTO toDTO(Buku buku) {
        return BukuResponseDTO.builder()
                .id(buku.getId())
                .namaBuku(buku.getNamaBuku())
                .category(buku.getCategory())
                .build();
    }

    public List<BukuResponseDTO> toListDTO(List<Buku> listBuku) {
        return listBuku.stream().map(lb -> BukuResponseDTO.builder()
                .id(lb.getId())
                .namaBuku(lb.getNamaBuku())
                .category(lb.getCategory())
                .build())
                .collect(Collectors.toList());
    }
}
