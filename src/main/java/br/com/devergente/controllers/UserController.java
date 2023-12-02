package br.com.devergente.controllers;

import br.com.devergente.enuns.EnunsUsers;
import br.com.devergente.models.users.Neurodivergent;
import br.com.devergente.models.users.User;
import br.com.devergente.repository.UsersRepository;
import br.com.devergente.services.ServiceUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private ServiceUsers serviceUsers;

    @PostMapping("/perfil")
    public ResponseEntity<User> create(@RequestBody User user ) {
        serviceUsers.create(user);
        return ResponseEntity.ok().build();
    }

}
