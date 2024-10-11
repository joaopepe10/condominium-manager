package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.apartment.PaymentProcessorService;
import condominiummanager.controller.ApartmentsApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequiredArgsConstructor
public class ApartmentController implements ApartmentsApi {

    private final PaymentProcessorService paymentProcessorService;

    @Override
    public ResponseEntity<Void> sendProofPayment(String apartmentNumber, MultipartFile fileProof, String description) {
        paymentProcessorService.processPayment(apartmentNumber, fileProof, description);
        return noContent().build();
    }
}
