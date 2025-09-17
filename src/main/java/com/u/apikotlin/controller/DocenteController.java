package com.u.apikotlin.controller;

import com.u.apikotlin.model.Docente;
import com.u.apikotlin.service.DocenteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteService service;

    public DocenteController(DocenteService service) {
        this.service = service;
    }

    @PostMapping
    public Docente insert(@RequestBody Docente docente) {
        return service.insert(docente);
    }

    @PutMapping("/{id}")
    public Docente update(@PathVariable Integer id, @RequestBody Docente docente) {
        return service.update(id, docente).orElseThrow();
    }

    @GetMapping
    public List<Docente> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Docente getById(@PathVariable Integer id) {
        return service.getById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

