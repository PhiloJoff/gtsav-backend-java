package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MOD_MODEL")
public class ModelEntity {
    @Id
    @Column(name = "MOD_ID")
    private String id ;

    @NotNull
    @NotEmpty
    @Column(name = "MOD_NAME", length = 50)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUP_ID")
    private SupplierEntity supplier;

}
