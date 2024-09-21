package barcante.condominiummanager.infra.repository.apartament.model;

import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.UUID;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_apartment")
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;


    @Column(unique = true, nullable = false)
    private String apartmentNumber;

    private String description;
}
