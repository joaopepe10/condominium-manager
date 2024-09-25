package barcante.condominiummanager.infra.repository.apartament.model;

import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.UUID;

import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_apartment")
public class ApartmentEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(unique = true, nullable = false)
    private String apartmentNumber;

    private String description;
}
