package br.thullyoo.lista_tarefa_back.repository;

import br.thullyoo.lista_tarefa_back.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
