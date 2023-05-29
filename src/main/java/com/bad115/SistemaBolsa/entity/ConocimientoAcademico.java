package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
}
