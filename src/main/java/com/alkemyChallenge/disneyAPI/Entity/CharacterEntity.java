/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemyChallenge.disneyAPI.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity        
class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String image;
    private String name;
    private int age;
    private Long weight;
    private String history;
    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "characters" )
    private Set<MovieEntity> movies = new HashSet<>();
}
