package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ofertas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 30)
    private String experiencia;

    @Column(length = 30)
    private String rango_salarial;

    @ManyToMany
    @JoinTable(name = "oferta_modalidad",
            joinColumns = @JoinColumn(name = "oferta_id"),
            inverseJoinColumns = @JoinColumn(name = "modalidad_id")
    )
    @JsonIgnore
    private Set<Modalidad> modalidades;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoria_oferta_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoriaOferta categoria_oferta;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "empresa_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Empresa empresa;

    @ManyToMany
    //@JoinTable(name = "aspirante_oferta", joinColumns = @JoinColumn(name = "oferta_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "aspirante_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Aspirante> aspirantes;
}
