package fr.philobox.gtsavbackendjava.mappers;

import fr.philobox.gtsavbackendjava.dtos.ModelRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.ModelResponseDTO;
import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    ModelResponseDTO modelToModelResponseDTO(ModelEntity modelEntity);

    ModelEntity modelRequestDTOToModel(ModelRequestDTO modelRequestDTO);
}
