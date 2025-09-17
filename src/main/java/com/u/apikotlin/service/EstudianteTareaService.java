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

    public EstudianteTarea insert(EstudianteTarea entity) {
        return repository.save(entity);
    }

    public EstudianteTarea update(EstudianteTarea entity) {
        return repository.save(entity);
    }

    public List<EstudianteTarea> getAll() {
        return repository.findAll();
    }

    public EstudianteTarea getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
    }
}