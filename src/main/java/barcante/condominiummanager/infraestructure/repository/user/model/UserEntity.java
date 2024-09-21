package barcante.condominiummanager.infraestructure.repository.user.model;

import barcante.condominiummanager.infraestructure.repository.apartament.model.ApartmentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.UUID;

import java.time.LocalDate;
import java.util.UUID;

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

    private String email;

    private String phoneNumber;

    private LocalDate paymentDate;

    @OneToOne(mappedBy = "user")
    private ApartmentEntity apartment;
}
