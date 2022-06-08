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
@Table(name="CAT_CATEGORY")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAT_ID")
    private UUID id ;

    @NotNull
    @NotEmpty
    @Column(name= "CAT_NAME", length = 50)
    private String name;





}
