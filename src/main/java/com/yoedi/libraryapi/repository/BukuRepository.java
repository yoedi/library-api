package com.yoedi.libraryapi.repository;

import com.yoedi.libraryapi.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    List<Buku> findByNamaBukuContainingIgnoreCase(String namaBuku);
}
