package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorias_oferta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CategoriaOferta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "categoria_oferta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Oferta> ofertas = new HashSet<>();
}
