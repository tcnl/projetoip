package rcs8tcnl.exceptions;

public class DrugsCompanionFoundException extends Exception {

	public DrugsCompanionFoundException() {
		super("Voce achou uma droga ao inves de um companion.");
	}
}
