package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
    private String documento_identidad;

    @Column(length = 30)
    private String primer_nombre;

    @Column(length = 30)
    private String segundo_nombre;

    @Column(length = 30)
    private String primer_apellido;

    @Column(length = 30)
    private String segundo_apellido;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
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
}
