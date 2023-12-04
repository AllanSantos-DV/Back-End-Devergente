package br.com.devergente.controllers;

import br.com.devergente.models.users.User;
import br.com.devergente.models.users.UsersDTO;
import br.com.devergente.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/perfil")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userServices.create(user));
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<UsersDTO> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userServices.findById(id));
    }
}
