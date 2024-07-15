package com.alura.forohub.controller;

import com.alura.forohub.dto.DatosAutenticacionUsuarioDTO;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuarioDTO datosAutenticacionUsuarioDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuarioDTO.getLogin(), datosAutenticacionUsuarioDTO.getContrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(JWTtoken);
    }
}

//    @Autowired
//    private UsuarioService usuarioService;
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
//        Usuario user = usuarioService.findByCorreoElectronico(usuario.getCorreoElectronico());
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with email: " + usuario.getCorreoElectronico());
//        }
//        // lógica de autenticación...
//        return ResponseEntity.ok("Login successful");
//    }