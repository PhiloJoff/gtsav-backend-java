package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SUP_SUPPLIER")
public class SupplierEntity {
    @Id
    @Column(name = "SUP_ID")
    private String id ;

    @NotNull
    @NotEmpty
    @Column(name = "SUP_NAME", length = 50, unique = true)
    private String name;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<ModelEntity> models;

}
