package com.u.apikotlin.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class EstudianteTareaResponseDTO {

    private Integer id;
    private EstudianteResponseDTO estudiante;
    private TareaSimpleResponseDTO tarea;
    private String estado;
    private Date fechaCompletada;
}
