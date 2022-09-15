package fr.philobox.gtsavbackendjava.services;

import fr.philobox.gtsavbackendjava.dtos.SupplierRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.SupplierResponseDTO;
import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import fr.philobox.gtsavbackendjava.entities.SupplierEntity;
import fr.philobox.gtsavbackendjava.mappers.SupplierMapper;
import fr.philobox.gtsavbackendjava.repositories.ModelRepository;
import fr.philobox.gtsavbackendjava.repositories.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
@Slf4j
public class SupplierServiceImpl implements SupplierService {
    private SupplierRepository supplierRepository;
    private ModelRepository modelRepository;
    private SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelRepository modelRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.modelRepository = modelRepository;
        this.supplierMapper = supplierMapper;
    }
    @Override
    public SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierRequestDto) {
        SupplierEntity supplierEntity = supplierMapper.supplierRequestDTOToSupplierEntity(supplierRequestDto);
        log.debug(supplierEntity.toString());

        supplierEntity.setId(UUID.randomUUID().toString());
        SupplierEntity supplierSaved = supplierRepository.save(supplierEntity);

        return supplierMapper.supplierToSupplierResponseDTO(supplierSaved);
    }

    @Override
    public SupplierResponseDTO getSupplierById(String id) {
        SupplierEntity supplierEntity = supplierRepository.findById(id).get();

        return supplierMapper.supplierToSupplierResponseDTO(supplierEntity);
    }

    @Override
    public SupplierResponseDTO updateSupplier(SupplierRequestDTO supplierRequestDto) {
        SupplierEntity supplierEntity = supplierMapper.supplierRequestDTOToSupplierEntity(supplierRequestDto);

        SupplierEntity supplierSaved = supplierRepository.save(supplierEntity);
        return supplierMapper.supplierToSupplierResponseDTO(supplierSaved);
    }

    @Override
    public void deleteSupplier(String id) throws Exception {
        SupplierEntity supplierEntity = supplierRepository.findById(id).get();

        if(supplierEntity == null) {
            throw new Exception("supplier not found");
        }
        List<ModelEntity> modelEntities = modelRepository.findAllBySupplierId(id);
        modelEntities.forEach(model -> modelRepository.delete(model));
        supplierRepository.delete(supplierEntity);
    }

    @Override
    public List<SupplierResponseDTO> getAllSuppliers() {
        List<SupplierEntity> supplierEntities = supplierRepository.findAll();

        List<SupplierResponseDTO> supplierResponseDTOs = supplierEntities.stream().map(
                supplier -> supplierMapper.supplierToSupplierResponseDTO(supplier)
        ).collect(Collectors.toList());

        return supplierResponseDTOs;
    }
}
