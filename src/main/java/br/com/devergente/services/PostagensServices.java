package br.com.devergente.services;

import br.com.devergente.models.Postagem;
import br.com.devergente.models.usuarios.UsuarioDTO;
import br.com.devergente.repository.PostagensRepository;
import br.com.devergente.repository.UsersDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostagensServices extends S3Services {

    @Autowired
    private PostagensRepository postagensRepository;

    @Autowired
    private UsersDTORepository usersDTORepository;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.bucketName}")
    private String bucketName;

    @Value("${aws.folder_post}")
    private String folderName;

    public Postagem save(String conteudo, MultipartFile file, String email) {
        Postagem postagem = new Postagem();
        postagem.setConteudo(conteudo);
        UsuarioDTO usuarioDTO = usersDTORepository.findByEmail(email);
        postagem.setUsuario(usuarioDTO);
        //String url = uploadParaS3(file, region, bucketName, folderName);
        //postagem.setImagemUrl(url);
        return postagensRepository.save(postagem);
    }

    public void update() {
        // TODO document why this method is empty
    }

    public void delete() {
        // TODO document why this method is empty
    }


    public List<Postagem> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Postagem> postagens = postagensRepository.findAll(pageable);
        List<Postagem> postagensList = new ArrayList<>();
        postagens.forEach(postagensList::add);
        Collections.reverse(postagensList);
        return postagensList;
    }
}
