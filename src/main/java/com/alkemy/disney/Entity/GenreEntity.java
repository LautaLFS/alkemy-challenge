/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.disney.Entity;

import java.util.*;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GenreEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String image;
    
    /* @JoinColumn(nullable = false)
    TODO; @OneToMany(fetch = FetchType.LAZY, mappedBy = "genre")
    private Set<MovieEntity> movies;*/
    
    
}
