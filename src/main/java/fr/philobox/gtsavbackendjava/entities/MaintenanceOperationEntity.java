package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MOP_MAINTENANCE_OPERATION")
public class MaintenanceOperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MOP_ID")
    private UUID id ;

    @Temporal(TemporalType.DATE)
    @Column(name = "MOP_MAINTENANCE_DATE")
    private Date maintenanceDate;

    @NotNull
    @NotEmpty
    @Column(name = "MOP_DESCRIPTION", length = 200)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIC_ID")
    private TicketEntity ticket;




}
