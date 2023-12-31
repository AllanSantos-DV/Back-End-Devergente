package br.com.devergente.repository;

import br.com.devergente.models.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurtidasRepository extends JpaRepository<Curtida, Integer> {
}
