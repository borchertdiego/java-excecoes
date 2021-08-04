package model.exception;

public class DomainException extends RuntimeException { 
//DomainException pois sera lancada na classe principal
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);
	}
}
