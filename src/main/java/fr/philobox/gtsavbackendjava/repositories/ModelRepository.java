package fr.philobox.gtsavbackendjava.repositories;

import fr.philobox.gtsavbackendjava.entities.ModelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<ModelEntity, String> {
    List<ModelEntity> findAllBySupplierId(String supplierId);
    Page<ModelEntity> findAllByNameContainsIgnoreCase(String name, Pageable pageable);
}
