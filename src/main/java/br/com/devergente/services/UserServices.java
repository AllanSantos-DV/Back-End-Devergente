package br.com.devergente.services;

import br.com.devergente.enuns.EnunsUsers;
import br.com.devergente.models.usuarios.*;
import br.com.devergente.repository.UsersDTORepository;
import br.com.devergente.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersDTORepository usersDTORepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Usuario create(Usuario usuario) {
        if (usersRepository.findByEmail(usuario.getEmail()) != null) return null;
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        switch (EnunsUsers.values()[usuario.getTipo_perfil() - 1]) {
            case NEURODIVERGENTE -> createNeurodivergent(usuario);
            case FAMILIAR-> createFamiliar(usuario);
            case PROFISSIONAL-> createProfessional(usuario);
            case EMPREGADOR-> createEmployer(usuario);
        }
        usersRepository.save(usuario);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getUsername(), usuario.getImg_perfil(), usuario.getEmail());
        usersDTORepository.save(usuarioDTO);
        return usuario;
    }

    public void update() {
        // TODO document why this method is empty
    }

    public void delete() {
        // TODO document why this method is empty
    }

    public void list() {
        // TODO document why this method is empty
    }

    public UsuarioDTO findById(Integer id) {
        return Optional.of(usersDTORepository.findById(id))
                .get().orElse( null);
    }

    public boolean findByEmail(String email, String senha) {
        return Optional.ofNullable(usersRepository.findByEmail(email))
                .filter(user -> passwordEncoder.matches(senha, user.getSenha()))
                .isPresent();
    }

    private void createNeurodivergent(Usuario usuario) {
        Neurodivergent neurodivergent = new Neurodivergent();
        neurodivergent.setUsuario(usuario);
        neurodivergent.setTipo_neurodivergencia(usuario.getCodigo());
        usuario.setNeurodivergent(neurodivergent);
    }

    private void createFamiliar(Usuario usuario) {
        Familiar familiar = new Familiar();
        familiar.setUsuario(usuario);
        familiar.setTipo_familiar(usuario.getCodigo());
        usuario.setFamiliar(familiar);
    }

    private void createProfessional(Usuario usuario) {
        Profissional profissional = new Profissional();
        profissional.setUsuario(usuario);
        profissional.setTipo_profissional(usuario.getCodigo());
        usuario.setProfissional(profissional);
    }

    private void createEmployer(Usuario usuario) {
        Empregador empregador = new Empregador();
        empregador.setUsuario(usuario);
        empregador.setCnpj(usuario.getCnpj());
        usuario.setEmpregador(empregador);
    }
}
