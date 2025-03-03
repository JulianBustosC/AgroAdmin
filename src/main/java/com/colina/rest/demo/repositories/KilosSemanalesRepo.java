/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.colina.rest.demo.repositories;

import com.colina.rest.demo.entidades.KilosSemanales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author julianB
 */
@Repository
public interface KilosSemanalesRepo extends JpaRepository<KilosSemanales, Integer>{
    
}
