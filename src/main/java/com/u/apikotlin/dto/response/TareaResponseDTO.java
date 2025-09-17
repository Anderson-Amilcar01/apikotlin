package com.u.apikotlin.dto.response;


import lombok.Setter;
import lombok.Getter;
import java.util.Date;
@Setter
@Getter
public class TareaResponseDTO {

    private Integer id;
    private String titulo;
    private String descripcion;
    private Date fechaEntrega;
    private String prioridad;
    private DocenteSimpleResponseDTO docente;
}
