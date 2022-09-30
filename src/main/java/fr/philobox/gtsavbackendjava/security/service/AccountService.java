package fr.philobox.gtsavbackendjava.security.service;

import fr.philobox.gtsavbackendjava.security.entities.AppRole;
import fr.philobox.gtsavbackendjava.security.entities.AppUser;

import java.util.Collection;

public interface AccountService {
    Collection<AppUser> findAllUsers();
    AppUser addUser(AppUser appUser);
    AppUser findUser(String name);
    void deleteUser(AppUser appUser);

    Collection<AppRole> findAllRoles();
    AppRole addRole(AppRole appRole);
    AppRole findRole(String name);
    void deleteRole(AppRole appRole);

    AppUser addRoleToUser(String appRole, String appUser) throws Exception;
    AppUser removeRoleToUser(String appRole, String appUser) throws Exception;


}
