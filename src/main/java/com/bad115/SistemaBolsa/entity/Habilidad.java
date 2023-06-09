package com.bad115.SistemaBolsa.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "habilidad")
public class Habilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_habilidad;

    private String categoria;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "habilidad")
    @JsonIgnore
    private List<AspiranteHabilidad> aspiranteHabilidad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "habilidad")
    @JsonIgnore
    private List<DetalleHabilidad> detalleHabilidad;
}
