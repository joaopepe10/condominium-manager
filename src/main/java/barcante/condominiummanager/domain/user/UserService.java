package barcante.condominiummanager.domain.user;

import barcante.condominiummanager.domain.apartment.ApartmentService;
import barcante.condominiummanager.domain.user.mapper.UserMapper;
import barcante.condominiummanager.infra.repository.user.UserRepository;
import barcante.condominiummanager.infra.repository.user.model.UserEntity;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final ApartmentService apartmentService;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, ApartmentService apartmentService) {
        this.userRepository = userRepository;
        this.mapper = userMapper;
        this.apartmentService = apartmentService;
    }

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

    public void update(UserEntity user) {
        userRepository.save(user);
    }
}
