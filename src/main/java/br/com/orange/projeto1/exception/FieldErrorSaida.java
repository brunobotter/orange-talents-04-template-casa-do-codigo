package br.com.orange.projeto1.exception;

public class FieldErrorSaida {

	private String field;
	private String message;

	public FieldErrorSaida() {
	}

	public FieldErrorSaida(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

	
}
