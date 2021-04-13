package br.com.petz.exception.runtime;

public class TechnicalException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TechnicalException(String mensagem) {
		super(mensagem);
	}
	
	public TechnicalException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}

}
