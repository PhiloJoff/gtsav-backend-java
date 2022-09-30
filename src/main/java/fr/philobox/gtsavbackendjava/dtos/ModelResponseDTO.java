package fr.philobox.gtsavbackendjava.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelResponseDTO {
    private String id;
    private String name;
    private SupplierResponseDTO supplier;
    private int currentPage;
    private int totalPages;
}
