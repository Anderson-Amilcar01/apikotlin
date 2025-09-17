package com.u.apikotlin.controller;
import com.u.apikotlin.dto.request.EstudianteTareaRequestDTO;
import com.u.apikotlin.dto.response.EstudianteTareaResponseDTO;
import com.u.apikotlin.mapper.EstudianteTareaMapper;
import com.u.apikotlin.model.EstudianteTarea;
import com.u.apikotlin.service.EstudianteTareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante_tareas")
public class EstudianteTareaController {

    private final EstudianteTareaService service;
    private final EstudianteTareaMapper mapper;

    public EstudianteTareaController(EstudianteTareaService service, EstudianteTareaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public EstudianteTareaResponseDTO insert(@RequestBody EstudianteTareaRequestDTO dto) {
        EstudianteTarea entity = mapper.toEntity(dto);
        return mapper.toResponse(service.insert(entity));
    }

    @PutMapping("/{id}")
    public EstudianteTareaResponseDTO update(@PathVariable Integer id,
                                             @RequestBody EstudianteTareaRequestDTO dto) {
        EstudianteTarea entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toResponse(service.update(entity));
    }

    @GetMapping
    public List<EstudianteTareaResponseDTO> getAll() {
        return mapper.toResponseList(service.getAll());
    }

    @GetMapping("/{id}")
    public EstudianteTareaResponseDTO getById(@PathVariable Integer id) {
        return mapper.toResponse(service.getById(id));
    }

    // Metodo para marcar tarea como completada
    @PutMapping("/{id}/completar")
    public EstudianteTareaResponseDTO marcarCompletada(@PathVariable Integer id) {
        EstudianteTarea entity = service.getById(id);
        entity.setEstado(EstudianteTarea.Estado.Completada);
        entity.setFechaCompletada(new java.util.Date());
        return mapper.toResponse(service.update(entity));
    }

}
