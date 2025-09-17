package com.u.apikotlin.service;
import com.u.apikotlin.model.EstudianteTarea;
import com.u.apikotlin.model.EstudianteTarea.Estado;
import com.u.apikotlin.repository.EstudianteTareaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteTareaService {

    private final EstudianteTareaRepository repository;

    public EstudianteTareaService(EstudianteTareaRepository repository) {
        this.repository = repository;
    }

    public EstudianteTarea insert(EstudianteTarea estudianteTarea) {
        return repository.save(estudianteTarea);
    }

    // Actualizar estado de la tarea
    public Optional<EstudianteTarea> updateEstado(Integer id, Estado estado) {
        return repository.findById(id).map(et -> {
            et.setEstado(estado);
            if (estado == Estado.Completada) {
                et.setFechaCompletada(new Date());
            }
            return repository.save(et);
        });
    }

    public List<EstudianteTarea> getPendientesByEstudiante(Integer estudianteId) {
        return repository.findByEstudianteIdAndEstado(estudianteId, Estado.Pendiente);
    }

    public List<EstudianteTarea> getCompletadasByEstudiante(Integer estudianteId) {
        return repository.findByEstudianteIdAndEstado(estudianteId, Estado.Completada);
    }
}
