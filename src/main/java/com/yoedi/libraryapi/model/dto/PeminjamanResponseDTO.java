package com.yoedi.libraryapi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PeminjamanResponseDTO {

    private long id;
    private long idUser;
    private long idBuku;
    private Date tanggalPinjam;
    private Date tanggalKembali;
}
