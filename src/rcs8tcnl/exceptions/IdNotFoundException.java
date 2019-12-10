package rcs8tcnl.exceptions;

public class IdNotFoundException extends Exception {

	public IdNotFoundException() {
		super("Nenhuma fonte de dinheiro com esse id foi encontrada.");
	}

}
