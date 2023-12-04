package br.com.devergente.repository;

import br.com.devergente.models.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}

