package com.u.apikotlin.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TareaRequestDTO {

    @NotBlank(message = "El título es obligatorio")
    private String titulo;

    private String descripcion;

    @NotNull(message = "La fecha de entrega es obligatoria")
    private Date fechaEntrega;

    @NotBlank(message = "La prioridad es obligatoria")
    private String prioridad;

    @NotNull(message = "El ID del docente es obligatorio")
    private Integer docenteId;

}
