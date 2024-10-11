package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.user.ProcessUserService;
import condominiummanager.controller.UsersApi;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

    private final ProcessUserService service;

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        var response = service.createUser(userRequest);
        return ok(response);
    }

}
