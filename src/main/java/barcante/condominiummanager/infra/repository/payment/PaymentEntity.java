package barcante.condominiummanager.infra.repository.payment;

import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = UUID)
    private UUID id;

    private LocalDate paymentDate;

    private String description;

    @Enumerated(EnumType.STRING)
    private MonthReference referenceMonth;

    @Lob
    @Column(name = "proof_of_payment", columnDefinition = "BLOB")
    private byte[] proofOfPayment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;


    public void buildDateAndMonthReference(LocalDate date){
        this.paymentDate = date;
        this.referenceMonth = MonthReference.getMonthCurrent(date);
    }
}
