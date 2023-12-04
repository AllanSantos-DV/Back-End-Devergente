package br.com.devergente.controllers;

import br.com.devergente.models.Postagem;
import br.com.devergente.services.PostagensServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PostagensController {

    @Autowired
    private PostagensServices postagensServices;

    @GetMapping("/postagens/page={init}&size={quantity}")
    public ResponseEntity<List<Postagem>> findAll(@PathVariable int init, @PathVariable int quantity) {
        return ResponseEntity.ok(postagensServices.findAll(init, quantity));
    }

    @PostMapping("/postagens")
    public ResponseEntity<Postagem> save(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(postagensServices.save(postagem));
    }
}
