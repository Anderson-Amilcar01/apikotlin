package com.u.apikotlin.controller;

import com.u.apikotlin.model.Docente;
import com.u.apikotlin.service.DocenteService;
import org.springframework.web.bind.annotation.*;
import com.u.apikotlin.dto.request.DocenteRequestDTO;
import com.u.apikotlin.dto.response.DocenteResponseDTO;
import com.u.apikotlin.mapper.DocenteMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    private final DocenteService service;
    private final DocenteMapper mapper;

    public DocenteController(DocenteService service, DocenteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public DocenteResponseDTO insert(@RequestBody DocenteRequestDTO dto) {
        Docente docente = mapper.toEntity(dto);
        return mapper.toResponse(service.insert(docente));
    }

    @PutMapping("/{id}")
    public DocenteResponseDTO update(@PathVariable Integer id,
                                     @RequestBody DocenteRequestDTO dto) {
        Docente docente = mapper.toEntity(dto);
        docente.setId(id);
        return mapper.toResponse(service.update(docente));
    }

    @GetMapping
    public List<DocenteResponseDTO> getAll() {
        return mapper.toResponseList(service.getAll());
    }

    @GetMapping("/{id}")
    public DocenteResponseDTO getById(@PathVariable Integer id) {
        return mapper.toResponse(service.getById(id));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}

