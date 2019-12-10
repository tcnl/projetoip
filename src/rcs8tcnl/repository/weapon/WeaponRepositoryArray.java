package rcs8tcnl.repository.weapon;

import rcs8tcnl.basics.Weapon;

public class WeaponRepositoryArray implements WeaponInterface, IteratorWeapon {
	private Weapon[] arsenal;
	private Weapon[] arrayIt;
	private int index;
	private int indexIterator;

	public WeaponRepositoryArray() {
		this.arsenal = new Weapon[0];
		this.index = 0;
	}

	public WeaponRepositoryArray(Weapon[] array) {
		arrayIt = new Weapon[array.length];
		for (int i = 0; i < index; i++) {
			arrayIt[i] = array[i];
		}
		this.indexIterator = 0;
	}

	public void insert(Weapon gun) {
		Weapon[] aux = new Weapon[this.arsenal.length + 1];
		for (int i = 0; i < index; i++) {
			aux[i] = this.arsenal[i];
		}
		aux[index] = gun;
		this.arsenal = aux;
		index++;
	}

	public void update(String serial, Weapon gun) {
		for (int i = 0; i < index; i++) {
			if (this.arsenal[i].getSerial().equalsIgnoreCase(serial)) {
				this.arsenal[i] = gun;
			}
		}
	}

	public void remove(String serial) {
		for (int i = 0; i < index; i++) {
			if (this.arsenal[i].getSerial().equalsIgnoreCase(serial)) {
				this.arsenal[i] = null;
				this.arsenal[i] = this.arsenal[index - 1];
				index--;
			}
		}
	}

	public Weapon search(String serial) {
		Weapon aux = null;
		for (int i = 0; i < index && (aux == null); i++) {
			if (this.arsenal[i] != null) {
				if (this.arsenal[i].getSerial().equalsIgnoreCase(serial)) {
					aux = this.arsenal[i];
				}
			}
		}
		return aux;
	}

	public boolean hasNext() {
		return indexIterator < arrayIt.length;
	}

	public Weapon next() {
		return arrayIt[indexIterator++];
	}

	public IteratorWeapon getIterator() {
		return new WeaponRepositoryArray(this.arsenal);
	}

}
