package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "aspirantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aspirante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String tipo_documento;

    @Column(length = 15)
    private String numero_documento_identidad;

    @Column(length = 30)
    private String primer_nombre;

    @Column(length = 30)
    private String segundo_nombre;

    @Column(length = 30)
    private String primer_apellido;

    @Column(length = 30)
    private String segundo_apellido;

    private Date fecha_nacimiento;

    @Column(length = 17)
    private String nit;

    @Column(length = 10)
    private String nup;

    @Column(length = 15)
    private String telefono_casa;

    @Column(length = 15)
    private String telefono_personal;

    @Column(length = 30)
    private String email;

    @Column(length = 200)
    private String redes_sociales;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "aspirante_oferta", joinColumns = @JoinColumn(name = "aspirante_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "oferta_id", referencedColumnName = "id"))
    private Set<Oferta> ofertas = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "genero_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Genero genero;

    @OneToMany(mappedBy = "aspirante", cascade = CascadeType.ALL)
    private Set<ConocimientoAcademico> conocimientos_academicos = new HashSet<>();

    @OneToMany(mappedBy = "aspirante", cascade = CascadeType.ALL)
    private Set<Certificacion> certificaciones = new HashSet<>();



























    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<ActividadAdicional> actividad_adicional;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<Referencia> referencia;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<Evento> evento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<Publicacion> publicacion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<Documento> documento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<ExperienciaLaboral> experiencia_laboral;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspirante")
    @JsonIgnore
    private List<AspiranteHabilidad> aspiranteHabilidad;
}
