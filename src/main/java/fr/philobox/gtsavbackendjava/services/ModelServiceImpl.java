package fr.philobox.gtsavbackendjava.services;

import fr.philobox.gtsavbackendjava.dtos.ModelRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.ModelResponseDTO;
import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import fr.philobox.gtsavbackendjava.mappers.ModelMapper;
import fr.philobox.gtsavbackendjava.repositories.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ModelServiceImpl implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelResponseDTO saveModel(ModelRequestDTO modelRequestDto) {
        ModelEntity modelEntity = modelMapper.modelRequestDTOToModel(modelRequestDto);

        modelEntity.setId(UUID.randomUUID().toString());
        ModelEntity modelEnitySaved = modelRepository.save(modelEntity);

        return modelMapper.modelToModelResponseDTO(modelEnitySaved);
    }

    @Override
    public ModelResponseDTO getModelById(String id) throws Exception {
        ModelEntity modelEntity = modelRepository.findById(id).orElse(null);

        if(modelEntity == null)
            throw new Exception("Model not found");
        return modelMapper.modelToModelResponseDTO(modelEntity);

    }

    @Override
    public ModelResponseDTO updateModel(String id, ModelRequestDTO modelRequestDto) throws Exception {

        if(modelRepository.existsById(id))
            throw new Exception("Model not found");
        ModelEntity modelEntity = modelMapper.modelRequestDTOToModel(modelRequestDto);

        ModelEntity modelEntityUpdated = modelRepository.save(modelEntity);

        return modelMapper.modelToModelResponseDTO(modelEntityUpdated);

    }

    @Override
    public void deleteModel(String id) throws Exception {
        ModelEntity modelEntity = modelRepository.findById(id).orElse(null);

        if(modelEntity == null)
            throw new Exception("Model not found");
        modelRepository.delete(modelEntity);

    }

    @Override
    public List<ModelResponseDTO> getAllModels() {
        List<ModelEntity> modelEntities = modelRepository.findAll();

        List<ModelResponseDTO> modelResponseDTOS = modelEntities.stream().map(
                model -> modelMapper.modelToModelResponseDTO(model)
        ).collect(Collectors.toList());

        return modelResponseDTOS;

    }

    @Override
    public List<ModelResponseDTO> getAllModelsBySupplier(String supplierId) {
        List<ModelEntity> modelEntities = modelRepository.findAllBySupplierId(supplierId);

        if(modelEntities.isEmpty())
            return null;

        List<ModelResponseDTO> modelResponseDTOS = modelEntities.stream().map(
                model -> modelMapper.modelToModelResponseDTO(model)
        ).collect(Collectors.toList());
        return modelResponseDTOS;
    }
}
