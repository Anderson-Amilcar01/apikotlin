package com.u.apikotlin.service;
import com.u.apikotlin.model.Docente;
import com.u.apikotlin.repository.DocenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    private final DocenteRepository repository;

    public DocenteService(DocenteRepository repository) {
        this.repository = repository;
    }

    public Docente insert(Docente docente) {
        return repository.save(docente);
    }

    public Optional<Docente> update(Integer id, Docente docente) {
        return repository.findById(id).map(d -> {
            d.setNombre(docente.getNombre());
            return repository.save(d);
        });
    }

    public List<Docente> getAll() {
        return repository.findAll();
    }

    public Optional<Docente> getById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
