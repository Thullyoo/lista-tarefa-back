package br.thullyoo.lista_tarefa_back.exceptions;

public class TarefaNotFoundException extends RuntimeException{
    public TarefaNotFoundException(String message){
        super(message);
    }
}
