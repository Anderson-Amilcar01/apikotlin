package com.u.apikotlin.controller;
import com.u.apikotlin.model.Tarea;
import com.u.apikotlin.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;

    public TareaController(TareaService service) {
        this.service = service;
    }

    @PostMapping
    public Tarea insert(@RequestBody Tarea tarea) {
        return service.insert(tarea);
    }

    @PutMapping("/{id}")
    public Tarea update(@PathVariable Integer id, @RequestBody Tarea tarea) {
        return service.update(id, tarea).orElseThrow();
    }

    @GetMapping
    public List<Tarea> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Tarea getById(@PathVariable Integer id) {
        return service.getById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
