package com.u.apikotlin.controller;

import com.u.apikotlin.dto.request.EstudianteRequestDTO;
import com.u.apikotlin.dto.response.EstudianteResponseDTO;
import com.u.apikotlin.mapper.EstudianteMapper;
import com.u.apikotlin.model.Estudiante;
import com.u.apikotlin.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;
    private final EstudianteMapper mapper;

    public EstudianteController(EstudianteService service, EstudianteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public EstudianteResponseDTO insert(@RequestBody EstudianteRequestDTO dto) {
        Estudiante estudiante = mapper.toEntity(dto);
        Estudiante saved = service.insert(estudiante);
        return mapper.toResponse(saved);
    }

    @PutMapping("/{id}")
    public EstudianteResponseDTO update(@PathVariable Integer id,
                                        @RequestBody EstudianteRequestDTO dto) {
        Estudiante estudiante = mapper.toEntity(dto);
        estudiante.setId(id);
        Estudiante updated = service.update(estudiante);
        return mapper.toResponse(updated);
    }

    @GetMapping
    public List<EstudianteResponseDTO> getAll() {
        return mapper.toResponseList(service.getAll());
    }

    @GetMapping("/{id}")
    public EstudianteResponseDTO getById(@PathVariable Integer id) {
        return mapper.toResponse(service.getById(id));
    }
}
