package fr.philobox.gtsavbackendjava.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelRequestDTO {
    private String id;
    private String name;
    private SupplierRequestDTO supplier;
}
