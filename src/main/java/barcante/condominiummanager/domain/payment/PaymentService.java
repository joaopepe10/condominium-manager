package barcante.condominiummanager.domain.payment;

import barcante.condominiummanager.domain.user.UserService;
import barcante.condominiummanager.infra.repository.apartament.model.ApartmentEntity;
import barcante.condominiummanager.infra.repository.payment.PaymentEntity;
import barcante.condominiummanager.infra.repository.payment.model.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

import static barcante.condominiummanager.infra.repository.payment.PaymentStatus.PAY;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserService userService;

    @Transactional
    public void pay(ApartmentEntity apartment, MultipartFile fileProof, String description) throws IOException {
        var user = userService.findById(apartment.getUser().getId());
        var payment = PaymentEntity.builder()
                .user(user)
                .proofOfPayment(fileProof.getBytes())
                .status(PAY)
                .description(description)
                .build();

        payment.buildDateAndMonthReference(LocalDate.now());
        user.getPayments().add(payment);
        userService.update(user);
        paymentRepository.save(payment);
    }
}
