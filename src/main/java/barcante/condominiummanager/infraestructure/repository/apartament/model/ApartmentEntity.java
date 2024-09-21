package barcante.condominiummanager.infraestructure.repository.apartament.model;

import barcante.condominiummanager.infraestructure.repository.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_apartment")
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private java.util.UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    private String description;
}
