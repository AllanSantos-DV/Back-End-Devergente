package br.com.devergente.controllers;

import br.com.devergente.config.JwtUtil;
import br.com.devergente.models.usuarios.Usuario;
import br.com.devergente.models.usuarios.UsuarioDTO;
import br.com.devergente.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/perfil")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(userServices.create(usuario));
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<UsuarioDTO> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userServices.findById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        if (userServices.findByEmail(usuario.getEmail(), usuario.getSenha())) {
            return ResponseEntity.ok()
                    .header("Authorization", "Bearer " + jwtUtil.generateToken(usuario.getEmail()))
                    .build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
