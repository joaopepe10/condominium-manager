package barcante.condominiummanager.infra.repository.apartament;

import barcante.condominiummanager.infra.repository.apartament.model.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentEntity, UUID> {

    Optional<ApartmentEntity> findByApartmentNumber(String apartmentNumber);
}
