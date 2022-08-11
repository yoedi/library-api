package com.yoedi.libraryapi.model.mapper;

import com.yoedi.libraryapi.model.Peminjaman;
import com.yoedi.libraryapi.model.dto.PeminjamanDTO;
import com.yoedi.libraryapi.model.dto.PeminjamanResponseDTO;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PeminjamanMapper {

    public Peminjaman toPeminjaman(PeminjamanDTO peminjamanDTO) {
        return Peminjaman.builder()
                .idBuku(peminjamanDTO.getIdBuku())
                .idUser(peminjamanDTO.getIdUser())
                .tanggalPinjam(peminjamanDTO.getTanggalPinjam())
                .tanggalKembali(peminjamanDTO.getTanggalKembali())
                .build();
    }

    public PeminjamanResponseDTO toDTO(Peminjaman peminjaman) {
        return PeminjamanResponseDTO.builder()
                .id(peminjaman.getId())
                .idBuku(peminjaman.getIdBuku())
                .idUser(peminjaman.getIdUser())
                .tanggalPinjam(peminjaman.getTanggalPinjam())
                .tanggalKembali(peminjaman.getTanggalKembali())
                .build();
    }

    public List<PeminjamanResponseDTO> toListDTO(List<Peminjaman> listPeminjaman) {
        return listPeminjaman.stream().map(lp -> PeminjamanResponseDTO.builder()
                .id(lp.getId())
                .idBuku(lp.getIdBuku())
                .idUser(lp.getIdUser())
                .tanggalPinjam(lp.getTanggalPinjam())
                .tanggalKembali(lp.getTanggalKembali())
                .build())
                .collect(Collectors.toList());
    }
}
