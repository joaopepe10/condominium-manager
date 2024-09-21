package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.user.ProcessUserService;
import condominiummanager.controller.UserApi;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final ProcessUserService service;

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        service.createUser(userRequest);
        return UserApi.super.createUser(userRequest);
    }
}
