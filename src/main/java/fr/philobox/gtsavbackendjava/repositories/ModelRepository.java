package fr.philobox.gtsavbackendjava.repositories;

import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelEntity, String> {
    List<ModelEntity> findAllBySupplierId(String supplierId);
    List<ModelEntity> findAllByNameContainsIgnoreCase(String name);
}
