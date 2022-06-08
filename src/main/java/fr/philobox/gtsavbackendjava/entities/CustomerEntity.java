package fr.philobox.gtsavbackendjava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CUS_CUSTOMER")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUS_ID")
    private UUID id ;

    @NotNull
    @NotEmpty
    @Column(name = "CUS_FIRSTNAME", length = 50)
    private String firstname;

    @NotNull
    @NotEmpty
    @Column(name = "CUS_LASTNAME", length = 50)
    private String lastname;

    @NotNull
    @NotEmpty
    @Column(name = "CUS_TEL", length = 10)
    private String tel;

    @NotNull
    @Email
    @Column(name = "CUS_EMAIL", length = 50)
    private String email;

    @NotNull
    @NotEmpty
    @Column(name = "CUS_ADDRESS", length = 200)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<TicketEntity> tickets;

}
