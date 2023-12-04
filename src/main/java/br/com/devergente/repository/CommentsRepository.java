package br.com.devergente.repository;


import br.com.devergente.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comentario, Integer> {
}
