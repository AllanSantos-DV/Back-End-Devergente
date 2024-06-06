package br.com.devergente.controllers;

import br.com.devergente.config.JwtUtil;
import br.com.devergente.models.Postagem;
import br.com.devergente.services.PostagensServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping
public class PostagensController {

    private final PostagensServices postagensServices;

    private final JwtUtil jwtUtil;

    public PostagensController(PostagensServices postagensServices, JwtUtil jwtUtil) {
        this.postagensServices = postagensServices;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/postagens/page={init}&size={quantity}")
    public ResponseEntity<List<Postagem>> findAll(@PathVariable int init, @PathVariable int quantity) {
        return ResponseEntity.ok(postagensServices.findAll(init, quantity));
    }

    @PostMapping("/postagens")
    public ResponseEntity<Postagem> save(@RequestPart("conteudo") String conteudo,
                                            @RequestPart("image") MultipartFile imagem,
                                         @RequestPart("data") String data,
                                         @RequestHeader("Authorization") String token) {
        String email = jwtUtil.getUsernameFromToken(token.substring(7));
        return ResponseEntity.ok(postagensServices.save(conteudo, imagem, email));
    }

}
