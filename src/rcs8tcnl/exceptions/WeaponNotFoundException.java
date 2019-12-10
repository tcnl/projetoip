package rcs8tcnl.exceptions;

public class WeaponNotFoundException extends Exception {

	public WeaponNotFoundException() {
		super("Nao foi encontrada nenhuma aram com esse serial.");
	}
}
