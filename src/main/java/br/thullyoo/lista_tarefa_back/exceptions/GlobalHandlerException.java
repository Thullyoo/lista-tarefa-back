package br.thullyoo.lista_tarefa_back.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "Nome já atribuido a uma tarefa";

        if (ex.getCause() != null && ex.getCause().getMessage().contains("unique constraint")) {
            message = "Nome ja atribuido a uma tarefa";
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(message, HttpStatus.BAD_REQUEST.toString()));
    }

    @ExceptionHandler(DataLimiteException.class)
        public ResponseEntity<ExceptionDTO> handleDataLimiteException(DataLimiteException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(ex.getMessage(), HttpStatus.BAD_REQUEST.toString()));
        }
    }

