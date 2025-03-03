/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.controller;

import com.colina.rest.demo.entidades.Kilo;
import com.colina.rest.demo.entidades.Trabajador;
import com.colina.rest.demo.service.KiloService;
import com.colina.rest.demo.service.TrabajadorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julianB
 */
@RestController
@RequestMapping("/kilos")
public class KiloController {
    @Autowired
    KiloService kService;
    @Autowired
    TrabajadorService trabajadorService;
    
    @PostMapping("/save")
    public Kilo post(@RequestBody Kilo kilo){
         return kService.save(kilo);    
    }
    @PostMapping("/saveWhitTrabajador/{idTrabajador}")
    public Kilo post(@RequestBody Kilo kilo,@PathVariable Long idTrabajador){
        
        Trabajador t= trabajadorService.getById(idTrabajador).orElse(null);
        
       if(t!= null)kilo.setTrabajador(t) ;
       return kService.save(kilo);
    }
     @PostMapping("/saveWhitTrabajadorName/{nombre}")
    public Kilo post(@RequestBody Kilo kilo,@PathVariable String nombre){
        Trabajador t= trabajadorService.getByNombre(nombre).orElse(null);if(t!= null)kilo.setTrabajador(t) ;
       if(t!= null)kilo.setTrabajador(t);
       return kService.save(kilo);       
    }
    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/getKilos")
    public List<Kilo> getKilos(){
        return kService.getKilos();
    }
    @GetMapping("/getByTrabajador/{idTrabajador}")
    public List<Kilo> getById(@PathVariable Long idTrabajador){
        return kService.getByTrabajador(trabajadorService.getById(idTrabajador).orElse(null));
    } 
    
    @GetMapping("/getOurderByTrabajadores")
    public List<Kilo> getOurderByTrabajadores(){
        return kService.joinTrabajador();
    } 
    
    
}
