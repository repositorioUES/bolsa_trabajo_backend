package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "experiencia_laboral")
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_experiencia;

    private String cargo;
    private String fecha_inicio;
    private String fecha_fin;
    private String funcion;
    private String nombre_empresa;
    private String direccion_empresa;
    private String telefono_empresa;
    private String email_empresa;


    //private Long id_aspirante;
}
