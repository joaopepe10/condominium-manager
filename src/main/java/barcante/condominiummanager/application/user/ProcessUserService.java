package barcante.condominiummanager.application.user;

import barcante.condominiummanager.domain.user.UserService;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessUserService {

    private final UserService userService;

    @Autowired
    public ProcessUserService(UserService userService) {
        this.userService = userService;
    }

    public UserResponse createUser(UserRequest request) {
        return userService.save(request);
    }
}
