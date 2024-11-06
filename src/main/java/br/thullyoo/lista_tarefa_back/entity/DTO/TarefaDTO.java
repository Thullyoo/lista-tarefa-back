package br.thullyoo.lista_tarefa_back.entity.DTO;


import java.util.Date;

public record TarefaDTO(String nome, Double custo, Date data_limite) {
}
