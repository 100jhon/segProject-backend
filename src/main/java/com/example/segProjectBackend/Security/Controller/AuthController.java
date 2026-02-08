package com.example.segProjectBackend.Security.Controller;


import com.example.segProjectBackend.Security.Dto.LoginRequestDto;
import com.example.segProjectBackend.Security.Dto.LoginResponseDto;
import com.example.segProjectBackend.Security.Dto.RegisterRequestDto;
import com.example.segProjectBackend.Security.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Acepta peticiones desde cualquier frontend, puedes personalizarlo
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        LoginResponseDto response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/registrar")
    public ResponseEntity<LoginResponseDto> registrar(@RequestBody RegisterRequestDto usuario){
        LoginResponseDto response = authenticationService.registrar(usuario);
        return ResponseEntity.ok(response);
    }
}
