
package com.colina.rest.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Generated;

/*
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
*/
public class Persona {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    */
    private Long id;
    private String nombre;
    private Long Identificacion;

    public Persona() {
    }

    public Persona(String nombre, Long Identificacion) {
        this.nombre = nombre;
        this.Identificacion = Identificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(Long Identificacion) {
        this.Identificacion = Identificacion;
    }
    
    
}
