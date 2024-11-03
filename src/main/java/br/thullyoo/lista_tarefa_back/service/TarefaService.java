package br.thullyoo.lista_tarefa_back.service;

import br.thullyoo.lista_tarefa_back.entity.Tarefa;
import br.thullyoo.lista_tarefa_back.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public Tarefa incluirTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    @Transactional
    public Tarefa editarTarefa(Long id, Tarefa tarefa) throws Exception {

        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isEmpty()){
            throw new Exception("Tarefa não registrada");
        }

        if(tarefa.getName() != null){
            tarefaOptional.get().setName(tarefa.getName());
        }

        if(tarefa.getCusto() != null){
            tarefaOptional.get().setCusto(tarefa.getCusto());
        }

        if(tarefa.getData_limite() != null){
            tarefaOptional.get().setData_limite(tarefa.getData_limite());
        }

        tarefaRepository.save(tarefaOptional.get());

        return tarefaOptional.get();
    }


}
