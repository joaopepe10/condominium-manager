package barcante.condominiummanager.domain.apartment;

import barcante.condominiummanager.infra.exception.BusinessException;
import barcante.condominiummanager.infra.repository.apartament.ApartmentRepository;
import barcante.condominiummanager.infra.repository.apartament.model.ApartmentEntity;
import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartmentService {

    private final ApartmentRepository repository;

    @Autowired
    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.repository = apartmentRepository;
    }

    public ApartmentEntity findApartmentByNumber(String apartmentNumber) {
        return findByApartmentNumber(apartmentNumber);
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
