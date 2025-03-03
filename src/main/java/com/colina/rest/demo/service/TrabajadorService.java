/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.service;

import com.colina.rest.demo.entidades.Trabajador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.colina.rest.demo.repositories.TrabajadorRepo;
import java.util.Optional;

/**
 *
 * @author julianB
 */
@Service
public class TrabajadorService {

    @Autowired
    TrabajadorRepo It;

    public List<Trabajador> getTrabajadores() {
        return It.findAll();
    }

    public Trabajador add(Trabajador t) {
        return It.save(t);
    }

    public Optional<Trabajador> getById(Long id) {
        return It.findById(id);
    }

    public Optional<Trabajador> getByNombre(String nombre) {
        return It.getByNombre(nombre);
    }

    public void delete(Long id) {
        It.deleteById(id);
    }

    public Trabajador put(Trabajador t, Long id) {
        return It.findById(id).map(tr -> {
            tr.setNombre(t.getNombre());
            tr.setIdentificacion(t.getIdentificacion());
            return It.save(tr);
        }).orElse(null);
    }
    
   

}
