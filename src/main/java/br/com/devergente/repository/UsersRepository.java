package br.com.devergente.repository;

import br.com.devergente.models.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}

