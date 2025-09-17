package com.u.apikotlin.service;

import com.u.apikotlin.model.Estudiante;
import com.u.apikotlin.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante insert(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public Estudiante update(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public List<Estudiante> getAll() {
        return repository.findAll();
    }

    public Estudiante getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}