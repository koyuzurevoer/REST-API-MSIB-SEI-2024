package com.msib_dul.msib_abdul.controller;

import com.msib_dul.msib_abdul.model.Lokasi;
import com.msib_dul.msib_abdul.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public ResponseEntity<Lokasi> addLokasi(@RequestBody Lokasi lokasi) {
        Lokasi createdLokasi = lokasiService.addLokasi(lokasi);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLokasi);
    }

    @GetMapping
    public ResponseEntity<List<Lokasi>> getAllLokasi() {
        List<Lokasi> lokasiList = lokasiService.getAllLokasi();
        return ResponseEntity.ok(lokasiList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lokasi> getLokasiById(@PathVariable Long id) {
        Optional<Lokasi> lokasi = lokasiService.getLokasiById(id);
        return lokasi.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        try {
            Lokasi updatedLokasi = lokasiService.updateLokasi(id, lokasi);
            return ResponseEntity.ok(updatedLokasi);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
        return ResponseEntity.noContent().build();
    }
}
