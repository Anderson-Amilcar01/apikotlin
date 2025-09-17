package com.u.apikotlin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarea_id")
    private Integer id;

    private String titulo;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @Enumerated(EnumType.STRING)
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @OneToMany(mappedBy = "tarea")
    private List<EstudianteTarea> estudiantesAsignados;

    public enum Prioridad {
        Baja, Media, Alta
    }
    public Tarea() {
    }
    public Tarea(Integer id) {
        this.id = id;
    }
    public Tarea(String titulo, String descripcion, Date fechaEntrega, Prioridad prioridad, Docente docente, List<EstudianteTarea> estudiantesAsignados) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.prioridad = prioridad;
        this.docente = docente;
        this.estudiantesAsignados = estudiantesAsignados;
    }
    public Tarea(Integer id, String titulo, String descripcion, Date fechaEntrega, Prioridad prioridad, Docente docente, List<EstudianteTarea> estudiantesAsignados) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.prioridad = prioridad;
        this.docente = docente;
        this.estudiantesAsignados = estudiantesAsignados;
    }
}