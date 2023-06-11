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
@Table(name = "instituciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @ManyToMany
    //@JoinTable(name = "conocimiento_academico_institucion", joinColumns = @JoinColumn(name = "institucion_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "conocimiento_academico_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<ConocimientoAcademico> conocimientos_academicos;
}
