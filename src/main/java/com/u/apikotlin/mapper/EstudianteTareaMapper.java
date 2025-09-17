package com.u.apikotlin.mapper;
import com.u.apikotlin.dto.request.*;
import com.u.apikotlin.dto.response.*;
import com.u.apikotlin.model.EstudianteTarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteTareaMapper {

    @Mapping(source = "estudianteId", target = "estudiante.id")
    @Mapping(source = "tareaId", target = "tarea.id")
    EstudianteTarea toEntity(EstudianteTareaRequestDTO dto);

    EstudianteTareaResponseDTO toResponse(EstudianteTarea entity);

    List<EstudianteTareaResponseDTO> toResponseList(List<EstudianteTarea> entities);
}