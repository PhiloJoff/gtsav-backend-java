package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRO_PROVIDER")
public class ProviderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRO_ID")
    private UUID id ;

    @NotNull
    @NotEmpty
    @Column(name = "PRO_NAME", length = 50)
    private String name;




}
