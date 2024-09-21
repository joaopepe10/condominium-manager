package barcante.condominiummanager.infra.repository.payment;

import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;

    private LocalDate paymentDate;

    private Double amount;

    @Lob
    @Column(name = "proof_of_payment", columnDefinition = "BLOB")
    private byte[] proofOfPayment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;
}
