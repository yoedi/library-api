package com.yoedi.libraryapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pinjam_buku")
public class Peminjaman implements Serializable {

    private static final long serialVersionUID = 8954239969605933555L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idUser;
    private long idBuku;
    private Date tanggalPinjam;
    private Date tanggalKembali;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private String updatedBy;
}
