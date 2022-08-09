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
@Table(name = "buku")
public class Buku implements Serializable {

    private static final long serialVersionUID = -5576373965817266380L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String namaBuku;
    private String category;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    private String updatedBy;
}
