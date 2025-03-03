/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.colina.rest.demo.repositories;

import com.colina.rest.demo.entidades.Kilo;
import com.colina.rest.demo.entidades.Trabajador;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julianB
 */
@Repository
public interface KiloRepo extends  JpaRepository<Kilo, Long>{
    List<Kilo> getByTrabajador(Trabajador trabajador);
    
    @Query("SELECT k FROM Kilo k JOIN FETCH k.trabajador t ORDER BY t.id")
List<Kilo> findAllKilosGroupedByTrabajador();


   
}
