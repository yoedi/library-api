package com.yoedi.libraryapi.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@Builder
public class PeminjamanDTO {

    private long idUser;
    private long idBuku;
    private Date tanggalPinjam;
    private Date tanggalKembali;
}
