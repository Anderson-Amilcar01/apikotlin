package com.u.apikotlin.service;

import com.u.apikotlin.dto.response.EstudianteTareaResponseDTO;
import com.u.apikotlin.mapper.EstudianteTareaMapper;
import com.u.apikotlin.model.Estudiante;
import com.u.apikotlin.model.EstudianteTarea;
import com.u.apikotlin.repository.EstudianteRepository;
import com.u.apikotlin.repository.EstudianteTareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstudianteService {

    private final EstudianteRepository repository;
    private final EstudianteTareaRepository estudianteTareaRepository;
    private final EstudianteTareaMapper estudianteTareaMapper;

    // Insertar un nuevo estudiante
    public Estudiante insert(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // Actualizar estudiante
    public Estudiante update(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // Obtener todos los estudiantes
    public List<Estudiante> getAll() {
        return repository.findAll();
    }

    // Obtener estudiante por ID
    public Estudiante getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    // Obtener tareas pendientes de un estudiante
    public List<EstudianteTareaResponseDTO> getTareasPendientes(Integer estudianteId) {
        return estudianteTareaRepository.findByEstudianteIdAndEstado(estudianteId, EstudianteTarea.Estado.Pendiente)
                .stream()
                .map(estudianteTareaMapper::toResponse)
                .toList();
    }
}
