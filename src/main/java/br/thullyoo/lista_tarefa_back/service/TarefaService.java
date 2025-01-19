package br.thullyoo.lista_tarefa_back.service;

import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaDTO;
import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaOrdemDTO;
import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaOrdemDTOList;
import br.thullyoo.lista_tarefa_back.entity.Tarefa;
import br.thullyoo.lista_tarefa_back.exceptions.DataLimiteException;
import br.thullyoo.lista_tarefa_back.exceptions.TarefaNotFoundException;
import br.thullyoo.lista_tarefa_back.repository.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public Tarefa incluirTarefa(TarefaDTO dto){
        if (dto.data_limite().equals(LocalDate.now()) || dto.data_limite().isBefore(LocalDate.now()) ){
            throw new DataLimiteException("Data limite não pode ser hoje ou antes");
        }
        Tarefa tarefa = new Tarefa(dto);
        tarefa.setOrdem_apresentacao(listarTarefas().size() + 1);
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public void deletarTarefa(Long id) throws Exception {
        Optional<Tarefa> tarefaExcluir = tarefaRepository.findById(id);

        if (tarefaExcluir.isEmpty()){
            throw new TarefaNotFoundException("Tarefa não registrada");
        }

        List<Tarefa> tarefas = tarefaRepository.findAll();
        for (Tarefa tarefa : tarefas){
            if (tarefa.getOrdem_apresentacao() > tarefaExcluir.get().getOrdem_apresentacao()){
                tarefa.setOrdem_apresentacao(tarefa.getOrdem_apresentacao() - 1);
            }
        }
        tarefaRepository.deleteById(id);

    }

    @Transactional
    public Tarefa editarTarefa(Long id, TarefaDTO tarefa) throws Exception {

        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isEmpty()){
            throw new TarefaNotFoundException("Tarefa não registrada");
        }

        if(tarefa.nome() != null){
            tarefaOptional.get().setName(tarefa.nome());
        }

        if(tarefa.custo() != null){
            tarefaOptional.get().setCusto(Float.valueOf(tarefa.custo().replace(",", ".")));
        }

        if(tarefa.data_limite() != null){
            tarefaOptional.get().setData_limite(tarefa.data_limite());
        }

        tarefaRepository.save(tarefaOptional.get());

        return tarefaOptional.get();
    }

    @Transactional
    public List<Tarefa> editarOrdemTarefas(TarefaOrdemDTOList dtoList) throws Exception {
        for(TarefaOrdemDTO tarefaDto : dtoList.ordemList()){
            Optional<Tarefa> tarefa = tarefaRepository.findById(tarefaDto.id());
            if (tarefa.isEmpty()){
                throw new Exception("Tarefa não registrada");
            }
            tarefa.get().setOrdem_apresentacao(tarefaDto.ordem_apresentacao());
            tarefaRepository.save(tarefa.get());
        }
        return this.tarefaRepository.findAll();
    }
}
