package br.com.devergente.repository;

import br.com.devergente.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagasRepository extends JpaRepository<Vaga, Integer> {
}
