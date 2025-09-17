package com.u.apikotlin.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocenteRequestDTO {

    @NotBlank(message = "El nombre del docente es obligatorio")
    private String nombre;

}