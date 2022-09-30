package fr.philobox.gtsavbackendjava.security.repositories;

import fr.philobox.gtsavbackendjava.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findAppUserByUsername(String name);
}
