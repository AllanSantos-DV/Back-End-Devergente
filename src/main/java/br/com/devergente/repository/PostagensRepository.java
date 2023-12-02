package br.com.devergente.repository;

import br.com.devergente.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagensRepository extends JpaRepository<Postagem, Integer> {
}
