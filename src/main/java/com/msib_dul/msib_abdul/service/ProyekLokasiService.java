package com.msib_dul.msib_abdul.service;

import com.msib_dul.msib_abdul.model.ProyekLokasi;
import com.msib_dul.msib_abdul.repository.ProyekLokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyekLokasiService {

    private final ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    public ProyekLokasiService(ProyekLokasiRepository proyekLokasiRepository) {
        this.proyekLokasiRepository = proyekLokasiRepository;
    }

    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiRepository.findAll();
    }

    public ProyekLokasi saveProyekLokasi(ProyekLokasi proyekLokasi) {
        return proyekLokasiRepository.save(proyekLokasi);
    }
}
