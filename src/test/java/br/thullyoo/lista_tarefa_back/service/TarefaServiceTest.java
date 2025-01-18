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

}