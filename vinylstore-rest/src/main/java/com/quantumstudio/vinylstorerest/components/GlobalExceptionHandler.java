package com.quantumstudio.vinylstorerest.components;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
/*
	@ExceptionHandler({DuplicateEntityException.class})
	public ResponseEntity handleExistsAlready(Exception exception){
		return ResponseEntity.status(HttpStatus.IM_USED).body(ErrorModel.of(exception.getMessage()));
	}
	//se hacen las excepciones hijas de Conflict y se pone aqui el confict y listo
	//ErrorModel clase para que se hagan modelos por defecto
	*/
}
