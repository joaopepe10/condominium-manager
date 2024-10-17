package barcante.condominiummanager.controller;

import barcante.condominiummanager.application.user.ProcessUserService;
import condominiummanager.controller.LoginApi;
import condominiummanager.model.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController implements LoginApi {

    private final ProcessUserService processUserService;

    @Override
    public ResponseEntity<String> login(LoginRequest loginRequest) {
        var isLoginValid = processUserService.login(loginRequest);
        return isLoginValid ? ResponseEntity.ok("Usuario autorizado") :
                ResponseEntity.badRequest().body("Usuario ou senha incorreto");
    }
}
