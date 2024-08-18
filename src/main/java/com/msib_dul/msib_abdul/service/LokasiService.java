package com.msib_dul.msib_abdul.service;

import com.msib_dul.msib_abdul.model.Lokasi;
import com.msib_dul.msib_abdul.repository.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi addLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public List<Lokasi> getAllLokasi() {
        return lokasiRepository.findAll();
    }

    public Optional<Lokasi> getLokasiById(Long id) {
        return lokasiRepository.findById(id);
    }

    public Lokasi updateLokasi(Long id, Lokasi lokasi) {
        if (lokasiRepository.existsById(id)) {
            lokasi.setId(id);
            return lokasiRepository.save(lokasi);
        } else {
            throw new RuntimeException("Lokasi tidak ditemukan dengan id " + id);
        }
    }

    public void deleteLokasi(Long id) {
        lokasiRepository.deleteById(id);
    }
}
