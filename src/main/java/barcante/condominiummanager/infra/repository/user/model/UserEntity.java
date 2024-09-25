package barcante.condominiummanager.infra.repository.user.model;

import barcante.condominiummanager.infra.repository.apartament.model.ApartmentEntity;
import barcante.condominiummanager.infra.repository.payment.PaymentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private GrantType grantType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PaymentEntity> payments;

    @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private ApartmentEntity apartment;
}
