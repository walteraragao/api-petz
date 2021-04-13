package br.com.petz.exception.runtime;

public class RequiredFieldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RequiredFieldException(String message) {
		super(message);
	}

}
