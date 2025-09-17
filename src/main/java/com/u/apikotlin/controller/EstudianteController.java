package com.u.apikotlin.controller;

import com.u.apikotlin.model.Estudiante;
import com.u.apikotlin.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @PostMapping
    public Estudiante insert(@RequestBody Estudiante estudiante) {
        return service.insert(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante update(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        return service.update(id, estudiante).orElseThrow();
    }

    @GetMapping
    public List<Estudiante> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Estudiante getById(@PathVariable Integer id) {
        return service.getById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
