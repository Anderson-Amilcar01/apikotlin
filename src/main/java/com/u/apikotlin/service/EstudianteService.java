package com.u.apikotlin.service;

import com.u.apikotlin.model.Estudiante;
import com.u.apikotlin.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    // Insertar estudiante
    public Estudiante insert(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // Actualizar estudiante
    public Optional<Estudiante> update(Integer id, Estudiante estudiante) {
        return repository.findById(id).map(e -> {
            e.setNombre(estudiante.getNombre());
            e.setMatricula(estudiante.getMatricula());
            e.setGrado(estudiante.getGrado());
            return repository.save(e);
        });
    }

    public List<Estudiante> getAll() {
        return repository.findAll();
    }

    public Optional<Estudiante> getById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
