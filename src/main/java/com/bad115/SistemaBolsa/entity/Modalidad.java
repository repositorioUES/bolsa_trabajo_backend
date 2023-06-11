package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modalidades")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Modalidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String nombre;

    @ManyToMany
    //@JsonBackReference
    //@JoinTable(name = "oferta_modalidad", joinColumns = @JoinColumn(name = "modalidad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "oferta_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Oferta> ofertas = new HashSet<>();
}
