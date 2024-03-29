package rcs8tcnl.business;

import java.io.IOException;

import rcs8tcnl.basics.Weapon;
import rcs8tcnl.exceptions.*;
import rcs8tcnl.repository.weapon.IteratorWeapon;
import rcs8tcnl.repository.weapon.WeaponInterface;

public class WeaponBusiness {

	private WeaponInterface arsenal;

	public WeaponBusiness(WeaponInterface rep) {
		this.arsenal = rep;
	}

	public void insert(Weapon gun) throws IOException,
			SerialAlreadyExistsException {
		Weapon aux = arsenal.search(gun.getSerial());
		if (aux == null) {
			arsenal.insert(gun);
		} else {
			throw new SerialAlreadyExistsException();
		}
	}

	public void update(String serial, Weapon gun) throws MissingUpdateException, IOException {
		Weapon aux = arsenal.search(serial);
		if (aux == null) {
			throw new MissingUpdateException();
		} else {
			arsenal.update(serial, gun);
		}
	}

	public void remove(String serial) throws WeaponNotFoundException, IOException {
		Weapon aux = arsenal.search(serial);
		if (aux == null) {
			throw new WeaponNotFoundException();
		} else {
			arsenal.remove(serial);
		}
	}

	public Weapon search(String serial) throws WeaponNotFoundException {
		Weapon aux = arsenal.search(serial);
		if (aux == null) {
			throw new WeaponNotFoundException();
		} else {
			return aux;
		}
	}

	public boolean hasNext() {
		return arsenal.hasNext();
	}

	public Weapon next() {
		return arsenal.next();
	}

	public IteratorWeapon getIterator() {
		return arsenal.getIterator();
	}

}
