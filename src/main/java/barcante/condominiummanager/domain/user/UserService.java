package barcante.condominiummanager.domain.user;

import barcante.condominiummanager.domain.apartment.ApartmentService;
import barcante.condominiummanager.infra.mapper.UserMapper;
import barcante.condominiummanager.infra.repository.user.UserRepository;
import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final ApartmentService apartmentService;

    public UserResponse save(UserRequest request){
        var apartment = apartmentService.findApartmentByNumber(request.getApartmentNumber());
        var entity = mapper.toEntity(request);
        entity.setApartment(apartment);
        apartmentService.setUser(entity);
        return mapper.toResponse(userRepository.save(entity));
    }

    public UserEntity findById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new  IllegalArgumentException("User not found"));
    }

    public Optional<UserEntity> searchByUsarname(String username){
        return userRepository.findByUsername(username);
    }

    public void update(UserEntity user) {
        userRepository.save(user);
    }
}
