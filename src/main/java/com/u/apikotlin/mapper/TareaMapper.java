package com.u.apikotlin.mapper;
import com.u.apikotlin.dto.request.*;
import com.u.apikotlin.dto.response.*;
import com.u.apikotlin.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    @Mapping(source = "docenteId", target = "docente.id")
    Tarea toEntity(TareaRequestDTO dto);

    TareaResponseDTO toResponse(Tarea entity);

    TareaSimpleResponseDTO toSimpleResponse(Tarea entity);

    List<TareaResponseDTO> toResponseList(List<Tarea> entities);
}