package com.msib_dul.msib_abdul.controller;

import com.msib_dul.msib_abdul.model.ProyekLokasi;
import com.msib_dul.msib_abdul.service.ProyekLokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek-lokasi")
public class ProyekLokasiController {

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @GetMapping
    public List<ProyekLokasi> getAllProyekLokasi() {
        return proyekLokasiService.getAllProyekLokasi();
    }

    @PostMapping
    public ProyekLokasi createProyekLokasi(@RequestBody ProyekLokasi proyekLokasi) {
        return proyekLokasiService.saveProyekLokasi(proyekLokasi);
    }
}
