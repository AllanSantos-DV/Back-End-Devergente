package br.com.devergente.services;

import br.com.devergente.enuns.EnunsUsers;
import br.com.devergente.models.users.*;
import br.com.devergente.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsers {

    @Autowired
    private UsersRepository usersRepository;

    public void create(User user) {
        switch (EnunsUsers.values()[user.getTipo_perfil() - 1]) {
            case NEURODIVERGENTE -> createNeurodivergent(user);
            case FAMILIAR-> createFamiliar(user);
            case PROFISSIONAL-> createProfessional(user);
            case EMPREGADOR-> createEmployer(user);
        }
        usersRepository.save(user);

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
