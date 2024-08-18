package com.msib_dul.msib_abdul.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "proyek_lokasi")
public class ProyekLokasi {

    @Embeddable
    public static class ProyekLokasiId implements Serializable {

        @Column(name = "proyek_id")
        private Long proyekId;

        @Column(name = "lokasi_id")
        private Long lokasiId;


        public Long getProyekId() {
            return proyekId;
        }

        public void setProyekId(Long proyekId) {
            this.proyekId = proyekId;
        }

        public Long getLokasiId() {
            return lokasiId;
        }

        public void setLokasiId(Long lokasiId) {
            this.lokasiId = lokasiId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProyekLokasiId that = (ProyekLokasiId) o;
            return Objects.equals(proyekId, that.proyekId) &&
                    Objects.equals(lokasiId, that.lokasiId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(proyekId, lokasiId);
        }
    }

    @EmbeddedId
    private ProyekLokasiId id;

    // Getters and Setters
    public ProyekLokasiId getId() {
        return id;
    }

    public void setId(ProyekLokasiId id) {
        this.id = id;
    }
}
