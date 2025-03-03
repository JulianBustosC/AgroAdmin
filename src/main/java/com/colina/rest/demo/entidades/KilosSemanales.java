/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Map;
@Entity
@Table(name = "kilos_semanales")
public class KilosSemanales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "trabajador_id", nullable = false)
    private Trabajador trabajador;
    /*
    @ElementCollection  // Si kilosDto es una lista de objetos simples, usa ElementCollection.
    @CollectionTable(name = "kilos_dia", joinColumns = @JoinColumn(name = "kilos_semanales_id"))
*/
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kilos_semanales", nullable = false)
    private List<KilosDia> kilosDto;
    
    private LocalDate fecha;
    
    
    @PrePersist
    protected void onCreate() {
        if (this.fecha == null) {
            this.fecha = LocalDate.now();
        }
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<KilosDia> getKilosDto() {
        return kilosDto;
    }

    public void setKilosDto(List<KilosDia> kilosDto) {
        this.kilosDto = kilosDto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

   

    public KilosSemanales(Integer id, Trabajador trabajador, List<KilosDia> kilosDto, LocalDate fecha) {
        this.id = id;
        this.trabajador = trabajador;
        this.kilosDto = kilosDto;
        this.fecha = fecha;
        
    }
    public KilosSemanales() {
    }

}
