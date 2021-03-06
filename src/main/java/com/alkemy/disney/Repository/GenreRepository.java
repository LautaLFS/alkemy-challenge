/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alkemy.disney.Repository;

import com.alkemy.disney.Entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lautaro
 */
@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long>{
    
}
