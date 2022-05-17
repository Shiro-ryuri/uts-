package com.lahuriuts.controller;

import com.lahuriuts.entity.Absen;
import com.lahuriuts.exception.PaketNotFoundException;
import com.lahuriuts.service.framework.PaketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/vaksinns")
public class PaketController {
    private final PaketService paketservice;

    @Autowired
    public PaketController(PaketService paketservice) {
        this.paketservice = paketservice;
    }

    @GetMapping
    public List<Absen> getAllPakets() {
        return paketservice.getAllPakets();
    }

    @GetMapping(value = "/{id}")
    public Absen getStudentById(@PathVariable("id") @Min(1) Long id) {
        Absen std = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public Absen addPaket(@Valid @RequestBody Absen std) {
        return paketservice.save(std);
    }

    @PutMapping(value = "/{id}")
    public Absen updatePaket(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Absen newStd) {
        Absen absen = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        absen.setFirstName(newStd.getFirstName());
        absen.setLastName(newStd.getLastName());
        absen.setEmail(newStd.getEmail());
        absen.setPhoneNumber(newStd.getPhoneNumber());
        return paketservice.save(absen);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        Absen std = paketservice.findById(id)
                .orElseThrow(() -> new PaketNotFoundException("Student with " + id + " is Not Found!"));
        paketservice.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}
