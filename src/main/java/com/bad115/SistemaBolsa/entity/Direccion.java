package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String calle;

    @Column(length = 100)
    private String colonia;

    @Column(length = 20)
    private String numero_casa;

    @Column(length = 20)
    private String pasaje;

    @OneToOne
    @JoinColumn(name = "aspirante_id")
    private Aspirante aspirante;
}
