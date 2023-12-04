package br.com.devergente.services;

import br.com.devergente.enuns.EnunsUsers;
import br.com.devergente.models.users.*;
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

    public User create(User user) {
        if (usersRepository.findByEmail(user.getEmail()) != null) return null;
        user.setSenha(passwordEncoder.encode(user.getSenha()));

        switch (EnunsUsers.values()[user.getTipo_perfil() - 1]) {
            case NEURODIVERGENTE -> createNeurodivergent(user);
            case FAMILIAR-> createFamiliar(user);
            case PROFISSIONAL-> createProfessional(user);
            case EMPREGADOR-> createEmployer(user);
        }
        usersRepository.save(user);
        UsersDTO usersDTO = new UsersDTO(user.getId(), user.getNome(), user.getUsername(), user.getImg_perfil(), user.getEmail());
        usersDTORepository.save(usersDTO);
        return user;
    }

    public void update() {
        // Implemente a lógica para atualizar um usuário aqui
    }

    public void delete() {
        // Implemente a lógica para deletar um usuário aqui
    }

    public void list() {
        // Implemente a lógica para listar os usuários aqui
    }

    public UsersDTO findById(Integer id) {
        return Optional.of(usersDTORepository.findById(id))
                .get().orElse( null);
    }

    public boolean findByEmail(String email, String senha) {
        return Optional.ofNullable(usersRepository.findByEmail(email))
                .filter(user -> passwordEncoder.matches(senha, user.getSenha()))
                .isPresent();
    }

    private void createNeurodivergent(User user) {
        Neurodivergent neurodivergent = new Neurodivergent();
        neurodivergent.setUsuario(user);
        neurodivergent.setTipo_neurodivergencia(user.getCodigo());
        user.setNeurodivergent(neurodivergent);
    }

    private void createFamiliar(User user) {
        Familiar familiar = new Familiar();
        familiar.setUsuario(user);
        familiar.setTipo_familiar(user.getCodigo());
        user.setFamiliar(familiar);
    }

    private void createProfessional(User user) {
        Professional professional = new Professional();
        professional.setUsuario(user);
        professional.setTipo_profissional(user.getCodigo());
        user.setProfessional(professional);
    }

    private void createEmployer(User user) {
        Employer employer = new Employer();
        employer.setUsuario(user);
        employer.setCnpj(user.getCnpj());
        user.setEmployer(employer);
    }
}
