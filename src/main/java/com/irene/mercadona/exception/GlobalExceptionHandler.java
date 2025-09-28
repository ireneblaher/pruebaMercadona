package com.irene.mercadona.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

/**
 * Manejador de excepciones globales
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
        String msg = ex.getConstraintViolations().stream()
                .map(v -> messageSource.getMessage(v.getMessage(), null, v.getMessage(), LocaleContextHolder.getLocale()))
                .reduce("", (a, b) -> a + b + "; ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String errores = ex.getBindingResult().getAllErrors().stream()
                .map(e -> messageSource.getMessage(e, LocaleContextHolder.getLocale()))
                .reduce("", (a, b) -> a + b + "; ");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    // Captura errores de tipo parámetro incorrecto
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

        String mensaje = messageSource.getMessage(
                "error.tipo.parametro",
                new Object[]{ex.getName()},          // {0} se reemplaza por el nombre del parámetro
                LocaleContextHolder.getLocale()      // idioma de la petición
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        String mensaje = messageSource.getMessage(ex.getMessage(), null, ex.getMessage(), LocaleContextHolder.getLocale());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensaje);
    }

    // Captura excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        String mensaje = messageSource.getMessage(ex.getMessage(), null, ex.getMessage(), LocaleContextHolder.getLocale());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mensaje);
    }
}
