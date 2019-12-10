package rcs8tcnl.exceptions;

public class PersonAlreadyExistsException extends Exception {

	public PersonAlreadyExistsException() {
		super("Ja existe uma pessoa com essa DogTag.");
	}
}
