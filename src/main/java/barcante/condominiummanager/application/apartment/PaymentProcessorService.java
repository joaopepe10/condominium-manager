package barcante.condominiummanager.application.apartment;

import barcante.condominiummanager.domain.apartment.ApartmentService;
import barcante.condominiummanager.domain.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentProcessorService {

    private final ApartmentService apartmentService;
    private final PaymentService paymentService;

    public void processPayment(String apartmentNumber, MultipartFile fileProof, String description){
        try {
            if (nonNull(apartmentNumber) && nonNull(fileProof) && apartmentService.existsApartmentByNumber(apartmentNumber)) {
                var apartment = apartmentService.findApartmentByNumber(apartmentNumber);
                paymentService.pay(apartment, fileProof, description);
            }
        } catch (Exception e) {
            log.error("Error: {} .", e.getMessage());
        }
    }
}
