package br.com.banco.desgraca.exception;

public class SaldoInsuficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
