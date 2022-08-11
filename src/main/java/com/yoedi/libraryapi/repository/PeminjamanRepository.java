package com.yoedi.libraryapi.repository;

import com.yoedi.libraryapi.model.Peminjaman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeminjamanRepository extends JpaRepository<Peminjaman, Long> {

    List<Peminjaman> findByIdUser(long idUser);
}
