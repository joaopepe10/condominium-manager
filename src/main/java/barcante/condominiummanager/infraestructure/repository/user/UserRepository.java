package barcante.condominiummanager.infraestructure.repository.user;

import barcante.condominiummanager.infraestructure.repository.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
