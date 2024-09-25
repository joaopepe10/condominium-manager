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

    @Column(nullable = false)
    private LocalDate paymentDate;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private MonthReference referenceMonth;

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    private byte[] proofOfPayment;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING;


    public void buildDateAndMonthReference(LocalDate date){
        this.paymentDate = date;
        this.referenceMonth = MonthReference.getMonthCurrent(date);
    }
}
