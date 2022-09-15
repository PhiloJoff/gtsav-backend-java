package fr.philobox.gtsavbackendjava.repositories;

import fr.philobox.gtsavbackendjava.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<SupplierEntity, String> {
}
