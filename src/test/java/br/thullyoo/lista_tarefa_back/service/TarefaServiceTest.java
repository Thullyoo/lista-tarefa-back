package br.thullyoo.lista_tarefa_back.service;

import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaDTO;
import br.thullyoo.lista_tarefa_back.entity.Tarefa;
import br.thullyoo.lista_tarefa_back.exceptions.DataLimiteException;
import br.thullyoo.lista_tarefa_back.repository.TarefaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @InjectMocks
    private TarefaService tarefaService;

    @Mock
    private TarefaRepository tarefaRepository;

    @Test
    public void deveLancarDataLimiteException(){
        TarefaDTO tarefaDTO = new TarefaDTO("Criar um site", "2000", LocalDate.MIN);
        assertThrows(DataLimiteException.class, () -> tarefaService.incluirTarefa(tarefaDTO));
    }

    @Test
    public void deveRetornarTarefaIncluida(){
        TarefaDTO tarefaDTO = new TarefaDTO("Criar um site", "2000", LocalDate.now().plusDays(1L));
        Tarefa tarefa = new Tarefa(tarefaDTO);

        Mockito.when(tarefaRepository.save(Mockito.any(Tarefa.class))).thenReturn(tarefa);

        Tarefa tarefaResponse = tarefaService.incluirTarefa(tarefaDTO);

        assertEquals(tarefa, tarefaResponse);
    }

    @Test
    public void deveRetornarAListaDeTarefas(){
        TarefaDTO tarefaDTO1 = new TarefaDTO("Criar um site", "2000", LocalDate.now().plusDays(1L));
        Tarefa tarefa1 = new Tarefa(tarefaDTO1);
        TarefaDTO tarefaDTO2 = new TarefaDTO("Criar um site", "2000", LocalDate.now().plusDays(1L));
        Tarefa tarefa2 = new Tarefa(tarefaDTO2);
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.add(tarefa1);
        tarefas.add(tarefa2);

        Mockito.when(tarefaRepository.findAll()).thenReturn(tarefas);

        List<Tarefa> tarefaResponse = tarefaService.listarTarefas();

        assertEquals(tarefas, tarefaResponse);
    }

    @Test
    public void deveLancarException(){
        assertThrows(Exception.class, () -> tarefaService.deletarTarefa(1L));
    }

}