package com.u.apikotlin.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class DocenteResponseDTO {

    private Integer id;
    private String nombre;
    private List<TareaSimpleResponseDTO> tareas;
}
