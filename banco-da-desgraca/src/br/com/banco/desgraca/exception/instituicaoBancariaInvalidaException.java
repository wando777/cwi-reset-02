package br.com.banco.desgraca.exception;

public class instituicaoBancariaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public instituicaoBancariaInvalidaException(String msg) {
		super(msg);
	}
}
