package rcs8tcnl.exceptions;

public class SerialAlreadyExistsException extends Exception {

	public SerialAlreadyExistsException() {
		super("Ja existe uma arma com esse serial.");
	}
}
