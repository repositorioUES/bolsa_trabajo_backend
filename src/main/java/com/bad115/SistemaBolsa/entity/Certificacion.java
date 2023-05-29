package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "certificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Certificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String codigo;

    @Column(length = 50)
    private String nombre;

    @Column(length = 30)
    private String tipo;

    @Column(length = 50)
    private String institucion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha_inicio;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fecha_fin;
}
