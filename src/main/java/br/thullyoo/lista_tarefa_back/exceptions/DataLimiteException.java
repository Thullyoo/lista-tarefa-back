package br.thullyoo.lista_tarefa_back.exceptions;

public class DataLimiteException extends RuntimeException{
    public DataLimiteException(String message){
        super(message);
    }
}
