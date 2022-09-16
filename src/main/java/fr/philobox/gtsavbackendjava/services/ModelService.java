package fr.philobox.gtsavbackendjava.services;

import fr.philobox.gtsavbackendjava.dtos.ModelResponseDTO;
import fr.philobox.gtsavbackendjava.dtos.ModelRequestDTO;

import java.util.List;

public interface ModelService {
    ModelResponseDTO saveModel(ModelRequestDTO modelRequestDto);
    ModelResponseDTO getModelById(String id) throws Exception;
    ModelResponseDTO updateModel(String id, ModelRequestDTO modelRequestDto) throws Exception;
    void deleteModel(String id) throws Exception;
    List<ModelResponseDTO> getAllModels();
    List<ModelResponseDTO> getAllModelsBySupplier(String supplierId);


}
