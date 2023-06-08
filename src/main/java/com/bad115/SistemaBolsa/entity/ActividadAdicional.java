package com.bad115.SistemaBolsa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "actividad_adicional")
public class ActividadAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_actividad;

    private String nombre_actividad;
    private String descripcion_actividad;
    private String fecha_inicio;
    private String fecha_final;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name = "id_aspirante", nullable = false)
    private Aspirante aspirante;
}
