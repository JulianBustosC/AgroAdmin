
package com.colina.rest.demo.entidades;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "kilosDia")
public class KilosDia implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Dia dia;
    private Float kilo;

    public KilosDia(Dia dia, Float kilo) {
        this.dia = dia;
        this.kilo = kilo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.dia);
        hash = 37 * hash + Objects.hashCode(this.kilo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KilosDia other = (KilosDia) obj;
        if (this.dia != other.dia) {
            return false;
        }
        return Objects.equals(this.kilo, other.kilo);
    }

    public KilosDia() {
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Float getKilo() {
        return kilo;
    }

    public void setKilo(Float kilo) {
        this.kilo = kilo;
    }

    
}
