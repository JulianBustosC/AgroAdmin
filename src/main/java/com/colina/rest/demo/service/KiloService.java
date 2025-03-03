/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.service;

import com.colina.rest.demo.entidades.Kilo;
import com.colina.rest.demo.entidades.Trabajador;
import com.colina.rest.demo.repositories.KiloRepo;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianB
 */
@Service
public class KiloService {

    @Autowired
    KiloRepo kR;

    public List<Kilo> getKilos() {
        return kR.findAll();
    }

    public List<Kilo> getByTrabajador(Trabajador t) {
        return kR.getByTrabajador(t);
    }

    public Kilo save(Kilo kilo) {
        return kR.save(kilo);
    }

    public void addKilos(Trabajador trabajador, List<Kilo> kilos) {

        if (kilos != null) {
            Iterator it = kilos.iterator();
            kilos.forEach(kilo -> kilo.setTrabajador(trabajador));
            while (it.hasNext()) {
                kR.save((Kilo) it.next());
            }
        }
    }

    public List<Kilo> joinTrabajador() {
        return kR.findAllKilosGroupedByTrabajador();
    }
}
