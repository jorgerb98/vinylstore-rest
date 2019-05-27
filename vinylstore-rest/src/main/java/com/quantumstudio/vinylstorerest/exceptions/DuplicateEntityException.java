package com.quantumstudio.vinylstorerest.exceptions;

public class DuplicateEntityException extends Exception {
	public DuplicateEntityException() {
		super("La entidad ya existe");
	}
}
