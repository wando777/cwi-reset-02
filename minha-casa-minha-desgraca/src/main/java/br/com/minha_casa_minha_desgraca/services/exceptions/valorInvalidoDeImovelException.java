package br.com.minha_casa_minha_desgraca.services.exceptions;

public class valorInvalidoDeImovelException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public valorInvalidoDeImovelException(String msg) {
		super(msg);
	}

}
