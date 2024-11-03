package barcante.condominiummanager.application.user;

import barcante.condominiummanager.domain.user.UserService;
import barcante.condominiummanager.infra.exception.UserNotFoundException;
import barcante.condominiummanager.infra.mapper.UserMapper;
import condominiummanager.model.LoginRequest;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessUserService {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest request) {
        return userService.save(request);
    }

    public UserResponse login(LoginRequest loginRequest) {
        var entity =  userService.searchByUsarname(loginRequest.getUsername())
                .orElseThrow(UserNotFoundException::new);

        return userMapper.toResponse(entity);
    }
}
