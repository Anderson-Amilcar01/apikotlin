package com.u.apikotlin.repository;

import com.u.apikotlin.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findByDocenteId(Integer docenteId);
    List<Tarea> findByPrioridad(Tarea.Prioridad prioridad);
}