package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.apartment.PaymentProcessorService;
import condominiummanager.controller.ApartmentApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ApartmentController implements ApartmentApi {

    private final PaymentProcessorService paymentProcessorService;

    @Override
    public ResponseEntity<Void> sendProofPayment(String apartmentNumber, MultipartFile fileProof) {
        paymentProcessorService.processPayment(apartmentNumber, fileProof);
        return ok().build();
    }
}
