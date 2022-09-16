package fr.philobox.gtsavbackendjava.mappers;

import fr.philobox.gtsavbackendjava.dtos.ModelRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.ModelResponseDTO;
import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    @Mapping(source = "id", target = "modelId")
    @Mapping(source = "name", target = "modelName")
    @Mapping(source = "supplier.id", target = "supplier.supplierId")
    @Mapping(source = "supplier.name", target = "supplier.supplierName")
    ModelResponseDTO modelToModelResponseDTO(ModelEntity modelEntity);


    @Mapping(source = "modelId", target = "id")
    @Mapping(source = "modelName", target = "name")
    @Mapping(source = "supplier.supplierId", target = "supplier.id")
    @Mapping(source = "supplier.supplierName", target = "supplier.name")
    ModelEntity modelRequestDTOToModel(ModelRequestDTO modelRequestDTO);
}
