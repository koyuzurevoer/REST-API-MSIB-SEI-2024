package com.msib_dul.msib_abdul.service;

import com.msib_dul.msib_abdul.model.Proyek;
import com.msib_dul.msib_abdul.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public Proyek addProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Optional<Proyek> getProyekById(Long id) {
        return proyekRepository.findById(id);
    }

    public Proyek updateProyek(Long id, Proyek proyek) {
        if (proyekRepository.existsById(id)) {
            proyek.setId(id);
            return proyekRepository.save(proyek);
        } else {
            throw new RuntimeException("Proyek tidak ditemukan dengan id " + id);
        }
    }

    public void deleteProyek(Long id) {
        proyekRepository.deleteById(id);
    }
}
