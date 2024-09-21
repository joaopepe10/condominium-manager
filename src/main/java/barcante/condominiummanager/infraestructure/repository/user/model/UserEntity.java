package barcante.condominiummanager.infraestructure.repository.user.model;

import barcante.condominiummanager.infraestructure.repository.apartament.model.ApartmentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDate paymentDate;

    @OneToOne(mappedBy = "user")
    private ApartmentEntity apartment;
}
