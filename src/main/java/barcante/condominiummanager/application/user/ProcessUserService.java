package barcante.condominiummanager.application.user;

import barcante.condominiummanager.domain.user.UserService;
import barcante.condominiummanager.infra.exception.UserNotFoundException;
import condominiummanager.model.LoginRequest;
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

    public boolean login(LoginRequest loginRequest) {
        var entity = userService.searchByUsarname(loginRequest.getUsername())
                .orElseThrow(UserNotFoundException::new);

        return entity.getPassword().equals(loginRequest.getPassword());
    }
}
