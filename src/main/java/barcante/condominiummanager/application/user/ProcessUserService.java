package barcante.condominiummanager.application.user;

import barcante.condominiummanager.domain.UserService;
import condominiummanager.model.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessUserService {

    private final UserService userService;

    public void createUser(UserRequest userRequest) {

    }
}
