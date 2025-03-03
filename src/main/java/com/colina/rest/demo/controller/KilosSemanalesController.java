/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.controller;

import com.colina.rest.demo.entidades.KilosDia;
import com.colina.rest.demo.entidades.KilosSemanales;
import com.colina.rest.demo.service.KilosSemanalesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julianB
 */
@RestController
@RequestMapping("/KilosSemanales")
public class KilosSemanalesController {
    @Autowired
    KilosSemanalesService kService;
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/getKilosSemanales")
    public List<KilosSemanales> getKilosSemanales(){
       return kService.getKilosSemanales();
    }             
    @PostMapping("/save/{id_trabajador}")
    public KilosSemanales post(@RequestBody KilosSemanales kilosSemanales,Long id_trabajador){
        System.out.println("id: "+id_trabajador);
        return  kService.save(id_trabajador, kilosSemanales);
    }
    
    @PostMapping("/save/whitKilosAndT")
    public void post(@RequestBody List<KilosDia> kilos){      
         kService.save(1L, kilos);
    }    
}
