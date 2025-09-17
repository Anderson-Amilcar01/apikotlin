package com.u.apikotlin.controller;

import com.u.apikotlin.dto.request.TareaRequestDTO;
import com.u.apikotlin.dto.response.TareaResponseDTO;
import com.u.apikotlin.mapper.TareaMapper;
import com.u.apikotlin.model.Tarea;
import com.u.apikotlin.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private final TareaService service;
    private final TareaMapper mapper;

    public TareaController(TareaService service, TareaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public TareaResponseDTO insert(@RequestBody TareaRequestDTO dto) {
        Tarea tarea = mapper.toEntity(dto);
        return mapper.toResponse(service.insert(tarea));
    }

    @PutMapping("/{id}")
    public TareaResponseDTO update(@PathVariable Integer id,
                                   @RequestBody TareaRequestDTO dto) {
        Tarea tarea = mapper.toEntity(dto);
        tarea.setId(id);
        return mapper.toResponse(service.update(tarea));
    }

    @GetMapping
    public List<TareaResponseDTO> getAll() {
        return mapper.toResponseList(service.getAll());
    }

    @GetMapping("/{id}")
    public TareaResponseDTO getById(@PathVariable Integer id) {
        return mapper.toResponse(service.getById(id));
    }
}
