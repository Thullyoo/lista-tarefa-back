package br.thullyoo.lista_tarefa_back.entity.DTO;


import java.time.LocalDate;

public record TarefaDTO(String nome, String custo, LocalDate data_limite) {
}
