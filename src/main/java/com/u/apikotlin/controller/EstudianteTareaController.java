package com.u.apikotlin.controller;
import com.u.apikotlin.model.EstudianteTarea;
import com.u.apikotlin.model.EstudianteTarea.Estado;
import com.u.apikotlin.service.EstudianteTareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante-tareas")
public class EstudianteTareaController {

    private final EstudianteTareaService service;

    public EstudianteTareaController(EstudianteTareaService service) {
        this.service = service;
    }

    @PostMapping
    public EstudianteTarea insert(@RequestBody EstudianteTarea estudianteTarea) {
        return service.insert(estudianteTarea);
    }

    @PutMapping("/{id}/estado")
    public EstudianteTarea updateEstado(@PathVariable Integer id, @RequestParam Estado estado) {
        return service.updateEstado(id, estado).orElseThrow();
    }

    @GetMapping("/pendientes/{estudianteId}")
    public List<EstudianteTarea> getPendientes(@PathVariable Integer estudianteId) {
        return service.getPendientesByEstudiante(estudianteId);
    }

    @GetMapping("/completadas/{estudianteId}")
    public List<EstudianteTarea> getCompletadas(@PathVariable Integer estudianteId) {
        return service.getCompletadasByEstudiante(estudianteId);
    }
}