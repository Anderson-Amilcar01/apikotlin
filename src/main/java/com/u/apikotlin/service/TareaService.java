package com.u.apikotlin.service;

import com.u.apikotlin.model.Tarea;
import com.u.apikotlin.repository.TareaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository repository;

    public TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    public Tarea insert(Tarea tarea) {
        return repository.save(tarea);
    }

    public Tarea update(Tarea tarea) {
        return repository.save(tarea);
    }

    public List<Tarea> getAll() {
        return repository.findAll();
    }

    public Tarea getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }
}