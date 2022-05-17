package com.lahuriuts.service.implementation;

import com.lahuriuts.entity.Absen;
import com.lahuriuts.repository.PaketRepository;
import com.lahuriuts.service.framework.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaketServiceImpl implements PaketService {
    private final PaketRepository paketRepository;

    @Autowired
    public PaketServiceImpl(PaketRepository paketRepository){
        this.paketRepository = paketRepository;
    }

    @Override
    public Optional<Absen> findByEmail(String email) {

        return paketRepository.findByEmail(email);
    }

    @Override
    public List<Absen> getAllPakets() {
        return paketRepository.findAll();
    }

    @Override
    public Optional<Absen> findById(Long id) {

        return paketRepository.findById(id);
    }



    @Override
    public Absen save(Absen std) {

        return paketRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {

        paketRepository.deleteById(id);
    }
}
