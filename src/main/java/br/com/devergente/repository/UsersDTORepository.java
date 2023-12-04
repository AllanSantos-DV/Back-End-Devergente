package br.com.devergente.repository;

import br.com.devergente.models.users.UsersDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDTORepository extends JpaRepository<UsersDTO, Integer> {
}
