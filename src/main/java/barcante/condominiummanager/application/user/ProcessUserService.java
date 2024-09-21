package barcante.condominiummanager.application.user;

import barcante.condominiummanager.domain.UserService;
import condominiummanager.model.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessUserService {

    private final UserService userService;

    @Autowired
    public ProcessUserService(UserService userService) {
        this.userService = userService;
    }

    public void createUser(UserRequest userRequest) {
        System.out.println(userRequest);
        userService.save();
    }
}
