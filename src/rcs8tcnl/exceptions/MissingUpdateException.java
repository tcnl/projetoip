package rcs8tcnl.exceptions;

public class MissingUpdateException extends Exception{
	
	public MissingUpdateException(){
		super("Voce nao pode atualizar algo que nao exista.");
	}

}
