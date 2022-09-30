package fr.philobox.gtsavbackendjava.security.service;

import fr.philobox.gtsavbackendjava.security.entities.AppRole;
import fr.philobox.gtsavbackendjava.security.entities.AppUser;
import fr.philobox.gtsavbackendjava.security.repositories.AppRoleRepository;
import fr.philobox.gtsavbackendjava.security.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@AllArgsConstructor
@Transactional
@Service
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public Collection<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser addUser(AppUser appUser) {
        String pw = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(pw);
        AppUser userSaved = appUserRepository.save(appUser);
        return userSaved;
    }

    @Override
    public AppUser findUser(String name) {
        return appUserRepository.findAppUserByUsername(name);
    }

    @Override
    public void deleteUser(AppUser appUser) {
        appUserRepository.delete(appUser);
    }

    @Override
    public Collection<AppRole> findAllRoles() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole addRole(AppRole appRole) {
        AppRole roleSaved = appRoleRepository.save(appRole);
        return roleSaved;
    }

    @Override
    public AppRole findRole(String name) {
        return appRoleRepository.findAppRoleByName(name);
    }

    @Override
    public void deleteRole(AppRole appRole) {
        appRoleRepository.delete(appRole);

    }

    @Override
    public AppUser addRoleToUser(String appRoleName, String appUsername) throws Exception {
        AppUser appUser = findUser(appUsername);
        AppRole appRole = findRole(appRoleName);
        if (appUser == null)
            throw new Exception("user not found");
        if (appRole == null)
            throw new Exception("role not found");
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser);
        return appUser;
    }

    @Override
    public AppUser removeRoleToUser(String appRoleName, String appUsername) throws Exception {
        AppRole appRole = findRole(appRoleName);
        AppUser appUser = findUser(appUsername);
        if (appRole == null)
            throw new Exception("role not found");
        if (appUser == null)
            throw new Exception("user not found");
        appUser.getRoles().remove(appRole);
        appUserRepository.save(appUser);
        return appUser;

    }
}
