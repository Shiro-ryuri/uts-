package com.lahuriuts.service.framework;

import com.lahuriuts.entity.Absen;

import java.util.List;
import java.util.Optional;

public interface PaketService {
    List<Absen> getAllPakets();

    Optional<Absen> findById(Long id);

    Optional<Absen> findByEmail(String email);

    Absen save(Absen std);

    void deleteById(Long id);
}
