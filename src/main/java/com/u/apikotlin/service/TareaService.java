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

    public Optional<Tarea> update(Integer id, Tarea tarea) {
        return repository.findById(id).map(t -> {
            t.setTitulo(tarea.getTitulo());
            t.setDescripcion(tarea.getDescripcion());
            t.setFechaEntrega(tarea.getFechaEntrega());
            t.setPrioridad(tarea.getPrioridad());
            t.setDocente(tarea.getDocente());
            return repository.save(t);
        });
    }

    public List<Tarea> getAll() {
        return repository.findAll();
    }

    public Optional<Tarea> getById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
