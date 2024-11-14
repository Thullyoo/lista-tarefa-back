package br.thullyoo.lista_tarefa_back.entity;

import br.thullyoo.lista_tarefa_back.entity.DTO.TarefaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "TB_TAREFAS")
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nome;

    private Float custo;

    private LocalDate data_limite;

    private Integer ordem_apresentacao;

    public Tarefa(TarefaDTO dto) {
        nome = dto.nome();
        data_limite = dto.data_limite();
        custo = Float.valueOf(dto.custo().replace(",","."));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }

    public LocalDate getData_limite() {
        return data_limite;
    }

    public void setData_limite(LocalDate data_limite) {
        this.data_limite = data_limite;
    }

    public Integer getOrdem_apresentacao() {
        return ordem_apresentacao;
    }

    public void setOrdem_apresentacao(Integer ordem_apresentacao) {
        this.ordem_apresentacao = ordem_apresentacao;
    }
}
