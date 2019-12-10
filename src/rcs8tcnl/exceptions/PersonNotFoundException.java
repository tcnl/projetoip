package rcs8tcnl.exceptions;

public class PersonNotFoundException extends Exception {

	public PersonNotFoundException() {
		super("Nao foi encontrada nenhuma pessoa com essa dogTag.");
	}
}
