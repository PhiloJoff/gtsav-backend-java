package fr.philobox.gtsavbackendjava.security.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String username;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    Collection<AppRole> roles;
}
