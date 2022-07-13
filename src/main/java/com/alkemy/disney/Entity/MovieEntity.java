/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.disney.Entity;


import java.util.*;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public
class MovieEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String image;
    
    private String title;
    
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "local_date")
    private Date date;
   
    private int rate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private GenreEntity genre;
    
    @Column(name = "genre_Id",insertable = false, updatable = false)
    private Long GenreId;
    //todo: manytomany
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<CharacterEntity> characters = new HashSet<>();
    
    
    
}
