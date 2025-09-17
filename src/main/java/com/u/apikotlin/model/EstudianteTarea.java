package com.u.apikotlin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Estudiante_Tarea")
public class EstudianteTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_tarea_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.Pendiente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_completada")
    private Date fechaCompletada;

    public enum Estado {
        Pendiente, Completada
    }

}

