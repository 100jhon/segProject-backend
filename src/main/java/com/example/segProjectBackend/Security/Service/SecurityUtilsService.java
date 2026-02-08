package com.example.segProjectBackend.Security.Service;

import com.example.segProjectBackend.Entity.UsuarioEntity;
import com.example.segProjectBackend.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtilsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String getUsernameLogueado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername(); // Devuelve username/email
            } else {
                return principal.toString(); // Si el principal es un String (caso JWT puro)
            }
        }
        return null;
    }

    public Integer getIdUsuarioLogueado() {
        String username = getUsernameLogueado();
        UsuarioEntity usuario = usuarioRepository.findByCorreo(username) // o findByUsername
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return usuario.getIdUsuario();
    }

    public boolean tieneRol(String rol) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .anyMatch(r -> r.equalsIgnoreCase(rol)); // Compara directo sin ROLE_
        }
        return false;
    }

}
