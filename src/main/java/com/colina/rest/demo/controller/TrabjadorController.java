/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.controller;

import com.colina.rest.demo.service.TrabajadorService;
import com.colina.rest.demo.entidades.Trabajador;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julianB
 */
@RestController
@RequestMapping("/trabajadores")
public class TrabjadorController {
    @Autowired
    TrabajadorService tService; 

    @CrossOrigin("http://127.0.0.1:5500")
    @GetMapping("/getTrabajadores")
    public List<Trabajador> getTrabjador(){
        
        return tService.getTrabajadores();
        
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PostMapping("/addTrabajador")
    public Trabajador save(@RequestBody Trabajador t){
        return tService.add(t);
    }
    
    @GetMapping("/get/findId/{id}")
    public Optional<Trabajador> getTrabajador(@PathVariable Long id){
        return tService.getById(id);
    }
    @GetMapping("/gets/findNombre/{nombre}")
    public Optional<Trabajador> getTrabajador(@PathVariable String nombre){
        return tService.getByNombre(nombre);
    }
    
    @PutMapping("/put")
    public Trabajador put(Trabajador t,Long id){
        return tService.put(t, id);
    }
    
    
}
