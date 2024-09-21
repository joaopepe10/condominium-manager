package barcante.condominiummanager.infraestructure.repository.user.model;

import barcante.condominiummanager.infraestructure.repository.apartament.model.ApartmentEntity;
import barcante.condominiummanager.infraestructure.repository.payment.PaymentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
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

    @OneToOne(mappedBy = "user")
    private ApartmentEntity apartment;
}
