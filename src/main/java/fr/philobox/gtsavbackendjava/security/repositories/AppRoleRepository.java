package fr.philobox.gtsavbackendjava.security.repositories;

import fr.philobox.gtsavbackendjava.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
    AppRole findAppRoleByName(String name);
}
