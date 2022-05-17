package com.lahuriuts.repository;

import com.lahuriuts.entity.Absen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaketRepository extends JpaRepository<Absen, Long> {
    Optional<Absen> findByEmail(String email);
}
