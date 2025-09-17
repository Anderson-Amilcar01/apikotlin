package com.u.apikotlin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    private Integer id;

    private String nombre;

    @Column(unique = true, nullable = false)
    private String matricula;

    private String grado;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteTarea> tareasAsignadas;

    public Estudiante() {
    }

    public Estudiante(Integer id) {
        this.id = id;
    }

    public Estudiante(String nombre, String matricula, String grado, List<EstudianteTarea> tareasAsignadas) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.grado = grado;
        this.tareasAsignadas = tareasAsignadas;
    }

    public Estudiante(Integer id, String nombre, String matricula, String grado, List<EstudianteTarea> tareasAsignadas) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.grado = grado;
        this.tareasAsignadas = tareasAsignadas;
    }
}
