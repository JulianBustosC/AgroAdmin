/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colina.rest.demo.repositories;

import com.colina.rest.demo.entidades.Trabajador;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julianB
 */
@Repository
public interface TrabajadorRepo extends JpaRepository<Trabajador, Long>{

    Optional<Trabajador> getByNombre(String nombre);
    
   
}
