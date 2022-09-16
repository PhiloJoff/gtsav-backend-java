package fr.philobox.gtsavbackendjava.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelResponseDTO {
    private String modelId;
    private String modelName;
    private SupplierResponseDTO supplier;
}
