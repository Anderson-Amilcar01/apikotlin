package com.u.apikotlin.service;
import com.u.apikotlin.model.Docente;
import com.u.apikotlin.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    private final DocenteRepository repository;

    public DocenteService(DocenteRepository repository) {
        this.repository = repository;
    }

    public Docente insert(Docente docente) {
        return repository.save(docente);
    }

    public Docente update(Docente docente) {
        return repository.save(docente);
    }

    public List<Docente> getAll() {
        return repository.findAll();
    }

    public Docente getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }
}