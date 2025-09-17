package com.u.apikotlin.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "docente_id")
    private Integer id;

    private String nombre;

    @OneToMany(mappedBy = "docente")
    private List<Tarea> tareas;

    public Docente() {
    }

    public Docente(Integer id) {
        this.id = id;
    }
    public Docente(String nombre, List<Tarea> tareas) {
        this.nombre = nombre;
        this.tareas = tareas;
    }
    public Docente(Integer id, String nombre, List<Tarea> tareas) {
        this.id = id;
        this.nombre = nombre;
        this.tareas = tareas;
    }
}