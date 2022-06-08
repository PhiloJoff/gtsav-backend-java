package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="TYP_TYPE")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TYP_ID")
    private UUID id ;

    @NotNull
    @NotEmpty
    @Column(name = "TYP_NAME")
    private String name;




}
