package com.u.apikotlin.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudianteTareaRequestDTO {

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer estudianteId;

    @NotNull(message = "El ID de la tarea es obligatorio")
    private Integer tareaId;
}
