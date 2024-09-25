package barcante.condominiummanager.application.user;

import barcante.condominiummanager.domain.user.UserService;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessUserService {

    private final UserService userService;

    public UserResponse createUser(UserRequest request) {
        return userService.save(request);
    }
}
