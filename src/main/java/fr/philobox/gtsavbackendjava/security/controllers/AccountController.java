package fr.philobox.gtsavbackendjava.security.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.philobox.gtsavbackendjava.security.entities.AppRole;
import fr.philobox.gtsavbackendjava.security.entities.AppUser;
import fr.philobox.gtsavbackendjava.security.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/account")
public class AccountController {
    private AccountService accountService;

    @GetMapping(path = "/users")
    public Collection<AppUser> getAllUsers() {
        return accountService.findAllUsers();
    }

    @PostMapping(path = "/add/user")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser addUser(@RequestBody AppUser appUser) {
        return accountService.addUser(appUser);
    }

    @PostMapping(path = "/add/role")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppRole addRole(@RequestBody AppRole appRole) {
        return accountService.addRole(appRole);
    }
    @PostMapping(path = "/add/role-to-user")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser addRoleToUser(@RequestParam(name = "role") String role, @RequestParam(name = "user") String user) throws Exception {
        return accountService.addRoleToUser(role, user);
    }

    @GetMapping(path = "/refreshToken")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorization = request.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer ")) {
            String jwt = authorization.substring("Bearer ".length());
            Algorithm algorithm = Algorithm.HMAC256("gt_sav");

            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
            String username = decodedJWT.getSubject();
            AppUser appUser = accountService.findUser(username);

            String jwtAccessToken = JWT.create()
                    .withSubject(username)
                    .withExpiresAt(new Date(System.currentTimeMillis() * 5 * 60 * 1000))
                    .withClaim("roles" , appUser.getRoles().stream().map(appRole -> appRole.getName()).collect(Collectors.toList()))
                    .sign(algorithm);
            Map<String, String> tokens = new HashMap<>();
            tokens.put("AccessToken", jwtAccessToken);
            tokens.put("RefreshToken", jwt);
            new ObjectMapper().writeValue(response.getOutputStream(), tokens);
        }
    }
}
