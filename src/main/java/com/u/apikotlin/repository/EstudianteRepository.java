package com.u.apikotlin.repository;

import com.u.apikotlin.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
        Optional<Estudiante> findByMatricula(String matricula);
}