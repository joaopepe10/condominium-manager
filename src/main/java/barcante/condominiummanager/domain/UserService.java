package barcante.condominiummanager.domain;

import barcante.condominiummanager.domain.apartment.ApartmentService;
import barcante.condominiummanager.domain.user.mapper.UserMapper;
import barcante.condominiummanager.infraestructure.repository.user.UserRepository;
import barcante.condominiummanager.infraestructure.repository.user.model.UserEntity;
import condominiummanager.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UserEntity save(UserRequest request){
        var apartment = apartmentService.findApartmentByNumber(request.getApartmentNumber());
        var entity = mapper.toEntity(request);
        entity.setApartment(apartment);
        apartmentService.setUser(entity);
        return userRepository.save(entity);
    }
}
