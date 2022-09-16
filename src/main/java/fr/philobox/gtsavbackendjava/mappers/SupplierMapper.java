package fr.philobox.gtsavbackendjava.mappers;

import fr.philobox.gtsavbackendjava.dtos.SupplierRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.SupplierResponseDTO;
import fr.philobox.gtsavbackendjava.entities.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    @Mapping(source = "id", target = "supplierId")
    @Mapping(source = "name", target = "supplierName")
    SupplierResponseDTO supplierToSupplierResponseDTO(SupplierEntity supplierEntity);


    @Mapping(source = "supplierId", target = "id")
    @Mapping(source = "supplierName", target = "name")
    SupplierEntity supplierRequestDTOToSupplierEntity(SupplierRequestDTO supplierRequestDTO);
}
