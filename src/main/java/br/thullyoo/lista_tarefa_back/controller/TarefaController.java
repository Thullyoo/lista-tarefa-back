package br.thullyoo.lista_tarefa_back.controller;

import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaDTO;
import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaOrdemDTOList;
import br.thullyoo.lista_tarefa_back.entity.Tarefa;
import br.thullyoo.lista_tarefa_back.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/tarefas")
@CrossOrigin("http://localhost:4200")
public class TarefaController {


    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas(){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.listarTarefas());
    }

    @PostMapping
    public ResponseEntity<Tarefa> incluirTarefa(@RequestBody TarefaDTO tarefaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.incluirTarefa(tarefaDTO));
    }

    @PutMapping
    public ResponseEntity<List<Tarefa>> editarOrdemTarefas(@RequestBody TarefaOrdemDTOList tarefaOrdemList) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.editarOrdemTarefas(tarefaOrdemList));
    }

    @DeleteMapping("/{id_tarefa}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable("id_tarefa") Long id) throws Exception {
        this.tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

}
