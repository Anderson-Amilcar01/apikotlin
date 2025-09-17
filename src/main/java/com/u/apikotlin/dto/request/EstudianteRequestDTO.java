package com.u.apikotlin.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudianteRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La matrícula es obligatoria")
    private String matricula;

    @NotBlank(message = "El grado es obligatorio")
    private String grado;

}