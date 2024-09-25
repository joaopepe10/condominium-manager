package barcante.condominiummanager.domain.apartment;

import barcante.condominiummanager.infra.exception.BusinessException;
import barcante.condominiummanager.infra.repository.apartament.ApartmentRepository;
import barcante.condominiummanager.infra.repository.apartament.model.ApartmentEntity;
import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository repository;

    public ApartmentEntity findApartmentByNumber(String apartmentNumber) {
        return findByApartmentNumber(apartmentNumber);
    }

    public boolean existsApartmentByNumber(String apartmentNumber) {
        return repository.existsByApartmentNumber(apartmentNumber);
    }

    public void setUser(UserEntity user){
        var entity = findByApartmentNumber(user.getApartment().getApartmentNumber());
        entity.setUser(user);
    }

    private ApartmentEntity findByApartmentNumber(String number){
        return repository.findByApartmentNumber(number)
                .orElseThrow(BusinessException::new);
    }


}
