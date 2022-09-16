package fr.philobox.gtsavbackendjava.mappers;

import fr.philobox.gtsavbackendjava.dtos.SupplierRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.SupplierResponseDTO;
import fr.philobox.gtsavbackendjava.entities.SupplierEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierResponseDTO supplierToSupplierResponseDTO(SupplierEntity supplierEntity);

    SupplierEntity supplierRequestDTOToSupplierEntity(SupplierRequestDTO supplierRequestDTO);
}
