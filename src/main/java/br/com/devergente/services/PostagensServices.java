package br.com.devergente.services;

import br.com.devergente.models.Postagem;
import br.com.devergente.repository.PostagensRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagensServices {

    @Autowired
    private PostagensRepository postagensRepository;

    public void create() {
        // Implemente a lógica para criar uma postagem aqui
    }

    public void update() {
        // Implemente a lógica para atualizar uma postagem aqui
    }

    public void delete() {
        // Implemente a lógica para deletar uma postagem aqui
    }


    public List<Postagem> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Postagem> postagens = postagensRepository.findAll(pageable);
        return postagens.stream().toList();

    }


    public Postagem save(Postagem postagem) {
        return postagensRepository.save(postagem);
    }
}
