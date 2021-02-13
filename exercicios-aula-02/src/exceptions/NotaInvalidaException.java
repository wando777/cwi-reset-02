package exceptions;

public class NotaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotaInvalidaException(String msg) {
		super(msg);
	}
}
