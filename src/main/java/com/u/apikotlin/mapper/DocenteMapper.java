package com.u.apikotlin.mapper;

import com.u.apikotlin.dto.request.*;
import com.u.apikotlin.dto.response.*;
import com.u.apikotlin.model.Docente;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocenteMapper {

    Docente toEntity(DocenteRequestDTO dto);

    DocenteResponseDTO toResponse(Docente entity);

    DocenteSimpleResponseDTO toSimpleResponse(Docente entity);

    List<DocenteResponseDTO> toResponseList(List<Docente> entities);
}
