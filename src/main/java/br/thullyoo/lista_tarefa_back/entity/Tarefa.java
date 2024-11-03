package br.thullyoo.lista_tarefa_back.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "TB_TAREFAS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double custo;

    private Date data_limite;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordem_apresentacao;

}
