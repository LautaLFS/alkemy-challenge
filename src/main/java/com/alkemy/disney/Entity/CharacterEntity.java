/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.disney.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@SQLDelete(sql = "UPDATE character_entity SET deleted=true WHERE id = ?")
@Where(clause = "deleted = false")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String image;
    private String name;
    private int age;
    private Long weight;
    private String history;
    private Boolean deleted = false;
    
    @ManyToMany( mappedBy = "characters" )
    private Set<MovieEntity> movies = new HashSet<>();
}
