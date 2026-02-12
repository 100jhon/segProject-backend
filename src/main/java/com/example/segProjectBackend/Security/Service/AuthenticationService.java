package com.example.segProjectBackend.Security.Service;

import com.example.segProjectBackend.Entity.RolEntity;
import com.example.segProjectBackend.Entity.UsuarioEntity;
import com.example.segProjectBackend.Mapper.UsuarioMapper;
import com.example.segProjectBackend.Repository.RolRepository;
import com.example.segProjectBackend.Repository.UsuarioRepository;
import com.example.segProjectBackend.Security.Dto.LoginRequestDto;
import com.example.segProjectBackend.Security.Dto.LoginResponseDto;
import com.example.segProjectBackend.Security.Dto.RegisterRequestDto;
import com.example.segProjectBackend.Security.UserInfoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public AuthenticationService(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, JwtService jwtService, RolRepository rolRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.rolRepository = rolRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;

    }

    public LoginResponseDto login(LoginRequestDto request) {
        try {
            //  Autenticar usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getCorreo(),
                            request.getPassword()
                    )
            );

            //  Buscar usuario en la base de datos
            UsuarioEntity usuario = usuarioRepository.findByCorreo(request.getCorreo())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            //  Adaptar a UserDetails
            UserDetails userDetails = new UserInfoDetails(usuario);

            //  Generar token JWT
            String token = jwtService.generateToken(userDetails);

            //  Devolver token al frontend
            return new LoginResponseDto(token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

    public LoginResponseDto registrar(RegisterRequestDto usuario) {
        if (usuarioRepository.findByCorreo(usuario.getCorreo()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Obtener rol por ID
        RolEntity rol = rolRepository.findById(usuario.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Mapear DTO a Entity
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuario);

        // Asignar el rol al usuario
        usuarioEntity.setIdRol(rol);

        //Se encripta el password y se inserta nuevamente en usuarioEntity
        usuarioEntity.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Guardar en base de datos
        usuarioRepository.save(usuarioEntity);
        // Generar token usando UserInfoDetails (que ahora también debe usar rol único)
        String token = jwtService.generateToken(new UserInfoDetails(usuarioEntity));

        return new LoginResponseDto(token);
    }
}
