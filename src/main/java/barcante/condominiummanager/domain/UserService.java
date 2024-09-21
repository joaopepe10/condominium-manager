package barcante.condominiummanager.domain;

import barcante.condominiummanager.infraestructure.repository.user.UserRepository;
import barcante.condominiummanager.infraestructure.repository.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(){
        return userRepository.save(new UserEntity());
    }
}
