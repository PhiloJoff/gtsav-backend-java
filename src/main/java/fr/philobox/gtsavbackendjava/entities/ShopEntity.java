package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SHO_SHOP")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SHO_ID")
    private UUID id ;

    @NotNull
    @NotEmpty
    @Column(name = "SHO_NAME", length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    private List<TicketEntity> tickets;





}
