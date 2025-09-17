package com.u.apikotlin.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TareaSimpleResponseDTO {

    private Integer id;
    private String titulo;
    private Date fechaEntrega;
    private String prioridad;
}
