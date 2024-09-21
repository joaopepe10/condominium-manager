package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.user.ProcessUserService;
import condominiummanager.controller.UserApi;
import condominiummanager.model.UserRequest;
import condominiummanager.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    private final ProcessUserService service;

    @Autowired
    public UserController(ProcessUserService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        var response = service.createUser(userRequest);
        return ResponseEntity.ok(response);
    }
}
