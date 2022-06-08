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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOD_ID")
    private UUID id ;

    @NotNull
    @NotEmpty
    @Column(name = "MOD_NAME", length = 50, unique = true)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUP_ID")
    private SupplierEntity supplier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    private List<TicketEntity> tickets;

    @ManyToMany
    @JoinTable(name = "MODEL_TYPE", joinColumns = { @JoinColumn(name = "MOD_ID") }, inverseJoinColumns = { @JoinColumn(name = "TYP_ID") })
    private List<TypeEntity> types;

    public ModelEntity(String name, SupplierEntity supplier) {
        this.name = name;
        this.supplier = supplier;
        this.tickets = new ArrayList<>();
        this.types = new ArrayList<>();
    }

}
