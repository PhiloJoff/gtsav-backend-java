package fr.philobox.gtsavbackendjava.services;

import fr.philobox.gtsavbackendjava.dtos.SupplierRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.SupplierResponseDTO;

import java.util.List;

public interface SupplierService {
    SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierRequestDto);
    SupplierResponseDTO getSupplierById(String id);
    SupplierResponseDTO updateSupplier(SupplierRequestDTO supplierRequestDto);
    void deleteSupplier(String id) throws Exception;
    List<SupplierResponseDTO> getAllSuppliers();

}
