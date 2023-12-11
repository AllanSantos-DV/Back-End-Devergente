package br.com.devergente.repository;

import br.com.devergente.models.usuarios.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDTORepository extends JpaRepository<UsuarioDTO, Integer> {
    UsuarioDTO findByEmail(String email);
}
