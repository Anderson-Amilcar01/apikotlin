package com.u.apikotlin.mapper;
import com.u.apikotlin.dto.request.EstudianteRequestDTO;
import com.u.apikotlin.dto.response.EstudianteResponseDTO;
import com.u.apikotlin.model.Estudiante;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    Estudiante toEntity(EstudianteRequestDTO dto);

    EstudianteResponseDTO toResponse(Estudiante entity);

    List<EstudianteResponseDTO> toResponseList(List<Estudiante> entities);
}