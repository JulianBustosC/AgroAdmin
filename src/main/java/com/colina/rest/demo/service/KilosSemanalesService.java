/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.service;

import com.colina.rest.demo.entidades.KilosDia;
import com.colina.rest.demo.entidades.KilosSemanales;
import com.colina.rest.demo.entidades.Trabajador;
import com.colina.rest.demo.repositories.KilosSemanalesRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianB
 */
@Service
public class KilosSemanalesService {
    @Autowired
    KilosSemanalesRepo ksR;
    @Autowired
    TrabajadorService tService;
    public List<KilosSemanales> getKilosSemanales(){
       return ksR.findAll();
    }
    
    public KilosSemanales save(Long trabajador_id,KilosSemanales kilosSemanales){
        if(kilosSemanales.getTrabajador()== null){
            Optional<Trabajador> byId = tService.getById(trabajador_id);
            if(byId.isPresent()){
                kilosSemanales.setTrabajador(byId.get());
            }
        }
       return ksR.save(kilosSemanales);
       
        
    }
   public KilosSemanales save(Long trabajadorId , List<KilosDia> kilos){
       KilosSemanales semana= new KilosSemanales();
       semana.setKilosDto(kilos);
       semana.setTrabajador(tService.getById(trabajadorId).get());
      return ksR.save(semana);
   }
}
