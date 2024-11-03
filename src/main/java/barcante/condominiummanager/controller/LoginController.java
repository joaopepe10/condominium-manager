package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.user.ProcessUserService;
import condominiummanager.controller.LoginApi;
import condominiummanager.model.LoginRequest;
import condominiummanager.model.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController implements LoginApi {

    private final ProcessUserService processUserService;

    @Override
    public ResponseEntity<UserResponse> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(processUserService.login(loginRequest));
    }
}
