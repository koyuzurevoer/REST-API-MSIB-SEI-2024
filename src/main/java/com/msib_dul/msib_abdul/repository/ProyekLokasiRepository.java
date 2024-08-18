package com.msib_dul.msib_abdul.repository;

import com.msib_dul.msib_abdul.model.ProyekLokasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyekLokasiRepository extends JpaRepository<ProyekLokasi, ProyekLokasi.ProyekLokasiId> {
}

