package fr.philobox.gtsavbackendjava.web;

import fr.philobox.gtsavbackendjava.dtos.ModelRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.ModelResponseDTO;
import fr.philobox.gtsavbackendjava.services.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/model")
@AllArgsConstructor
@CrossOrigin("*")
public class ModelRestController {
    private ModelService modelService;

    @GetMapping(path = "/models")
    public List<ModelResponseDTO> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping(path = "/models/supplier/{id}")
    public List<ModelResponseDTO> getAllModelsBySupplier(@PathVariable String id) {
        return modelService.getAllModelsBySupplier(id);
    }
    @GetMapping(path = "/models/search")
    public List<ModelResponseDTO> getAllModelsByName(@RequestParam(name= "name", defaultValue = "") String name) {
        return modelService.getAllModelsByName(name);
    }

    @GetMapping(path = "/models/{id}")
    public ModelResponseDTO getModel(@PathVariable String id) throws Exception {
        return modelService.getModelById(id);
    }

    @PostMapping(path = "/models/add")
    public ModelResponseDTO saveModel(ModelRequestDTO modelRequestDTO) {
        return modelService.saveModel(modelRequestDTO);
    }

    @PutMapping(path = "/models/update/{id}")
    public ModelResponseDTO saveModel(@PathVariable String id, ModelRequestDTO modelRequestDTO) throws Exception {
        return modelService.updateModel(id, modelRequestDTO);
    }

    @DeleteMapping(path = "/models/{id}")
    public void deleteModel(@PathVariable String id) throws Exception {
        modelService.deleteModel(id);
    }
}
