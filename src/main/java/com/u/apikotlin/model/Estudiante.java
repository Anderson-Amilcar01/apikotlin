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
}
