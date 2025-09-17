package com.u.apikotlin.repository;

import com.u.apikotlin.model.EstudianteTarea;
import com.u.apikotlin.model.EstudianteTarea.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstudianteTareaRepository extends JpaRepository<EstudianteTarea, Integer> {
    List<EstudianteTarea> findByEstudianteIdAndEstado(Integer estudianteId, Estado estado);

}
