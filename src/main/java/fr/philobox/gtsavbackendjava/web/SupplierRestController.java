package fr.philobox.gtsavbackendjava.web;

import fr.philobox.gtsavbackendjava.dtos.SupplierRequestDTO;
import fr.philobox.gtsavbackendjava.dtos.SupplierResponseDTO;
import fr.philobox.gtsavbackendjava.services.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/supplier")
@AllArgsConstructor
public class SupplierRestController {
    private SupplierService supplierService;

    @GetMapping(path = "/suppliers")
    public List<SupplierResponseDTO> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping(path = "/suppliers/{id}")
    public SupplierResponseDTO getSupplier(@PathVariable String id) {
        return supplierService.getSupplierById(id);
    }

    @PostMapping(path = "/suppliers/add")
    public SupplierResponseDTO saveSupplier(SupplierRequestDTO supplierRequestDTO) {
        return supplierService.saveSupplier(supplierRequestDTO);
    }

    @DeleteMapping(path = "/suppliers/{id}")
    public void deleteSupplier(@PathVariable String id) throws Exception {
        supplierService.deleteSupplier(id);
    }
}
