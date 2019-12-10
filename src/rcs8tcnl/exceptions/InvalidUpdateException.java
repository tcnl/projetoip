package rcs8tcnl.exceptions;

public class InvalidUpdateException extends Exception {

	public InvalidUpdateException() {
		super("Voce nao pode atualizar duas coisas diferentes.");
	}
}
