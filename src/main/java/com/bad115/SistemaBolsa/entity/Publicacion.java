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
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_publicacion;

    private String tipo_publicacion;
    private String lugar_publicacion;
    private String fecha_publicacion;
    private String edicion_libro;
    private String isbn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "publicacion")
    @JsonIgnore
    private List<DetallePublicacion> detallePublicacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @JoinColumn(name = "id_aspirante", nullable = false)
    private Aspirante aspirante;

}
