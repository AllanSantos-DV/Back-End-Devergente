package br.com.devergente.controllers;

import br.com.devergente.config.JwtUtil;
import br.com.devergente.dto.request.UsuarioLoginDTO;
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

    private final UserServices userServices;

    private final JwtUtil jwtUtil;

    /**
     * Constructor
     * @param userServices
     * @param jwtUtil
     */
    public UserController(UserServices userServices, JwtUtil jwtUtil) {
        this.userServices = userServices;
        this.jwtUtil = jwtUtil;
    }

    /**
     * Create a new user
     * @param usuario
     * @return
     */
    @PostMapping("/perfil")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(userServices.create(usuario));
    }

    /**
     * Get user by id
     * @param id
     * @return
     */
    @GetMapping("/perfil/{id}")
    public ResponseEntity<UsuarioDTO> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userServices.findById(id));
    }

    /**
     * Login User
     * @param usuarioLoginDTO
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioLoginDTO usuarioLoginDTO) {
        if (userServices.findByEmail(usuarioLoginDTO.getEmail(), usuarioLoginDTO.getSenha())) {
            return ResponseEntity.ok()
                    .header("Authorization", "Bearer " + jwtUtil.generateToken(usuarioLoginDTO.getEmail()))
                    .build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
