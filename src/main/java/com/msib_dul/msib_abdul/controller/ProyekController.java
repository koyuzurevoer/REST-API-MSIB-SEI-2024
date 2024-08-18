package com.msib_dul.msib_abdul.controller;

import com.msib_dul.msib_abdul.model.Proyek;
import com.msib_dul.msib_abdul.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<Proyek> addProyek(@RequestBody Proyek proyek) {
        Proyek createdProyek = proyekService.addProyek(proyek);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProyek);
    }

    @GetMapping
    public ResponseEntity<List<Proyek>> getAllProyek() {
        List<Proyek> proyekList = proyekService.getAllProyek();
        return ResponseEntity.ok(proyekList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable Long id) {
        Optional<Proyek> proyek = proyekService.getProyekById(id);
        return proyek.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyek) {
        try {
            Proyek updatedProyek = proyekService.updateProyek(id, proyek);
            return ResponseEntity.ok(updatedProyek);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return ResponseEntity.noContent().build();
    }
}
