package rcs8tcnl.repository.weapon;

import rcs8tcnl.basics.Weapon;

public class WeaponRepositoryList implements WeaponInterface, IteratorWeapon {
	private Weapon arsenal;
	private WeaponRepositoryList next;

	public WeaponRepositoryList() {
		this.arsenal = null;
		this.next = null;
	}

	public WeaponRepositoryList(Weapon arsenal, WeaponRepositoryList next) {
		this.arsenal = arsenal.cloneWeapon();
		if (next != null) {
			this.next = new WeaponRepositoryList(next.arsenal, next.next);
		}
	}

	public void insert(Weapon Weapon) {
		if (this.arsenal == null) {
			this.arsenal = Weapon;
		} else {
			if (next == null) {
				this.next = new WeaponRepositoryList();
			}
			this.next.insert(Weapon);
		}
	}

	public void update(String serial, Weapon Weapon) {
		if (this.arsenal.getSerial().equalsIgnoreCase(serial)) {
			this.arsenal = Weapon;
		} else {
			this.next.update(serial, Weapon);
		}

	}

	public void remove(String serial) {
		if (this.arsenal.getSerial().equalsIgnoreCase(serial)) {
			if (this.next != null) {
				this.arsenal = this.next.arsenal;
				this.next = this.next.next;
			} else {
				this.arsenal = null;
			}
		} else {
			this.next.remove(serial);
		}

	}

	public Weapon search(String serial) {
		Weapon aux = null;
		if (this.arsenal != null) {
			if (this.arsenal.getSerial().equalsIgnoreCase(serial)) {
				aux = this.arsenal;
			} else {
				if (next != null) {
					aux = this.next.search(serial);
				}
			}
		}
		return aux;
	}

	public boolean hasNext() {
		return (arsenal != null);
	}

	public Weapon next() {
		Weapon cache = this.arsenal;
		if (next != null) {
			next = next.next;
		}
		return cache;
	}

	public IteratorWeapon getIterator() {
		return new WeaponRepositoryList(this.arsenal, this.next);
	}

}
