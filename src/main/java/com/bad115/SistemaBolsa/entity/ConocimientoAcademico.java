package com.bad115.SistemaBolsa.entity;

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
import java.util.Set;

@Entity
@Table(name = "conocimientos_academicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConocimientoAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String tipo_conocimiento;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha_inico;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha_fin;

    @Column(length = 30)
    private String titulo_obtenido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aspirante_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Aspirante aspirante;

    @ManyToMany
    @JoinTable(name = "conocimiento_academico_institucion", joinColumns = @JoinColumn(name = "conocimiento_academico_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "institucion_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Institucion> instituciones = new HashSet<>();
}
