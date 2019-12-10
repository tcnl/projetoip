package rcs8tcnl.repository.weapon;

import rcs8tcnl.basics.Weapon;

public interface IteratorWeapon {
	public boolean hasNext();

	public Weapon next();

	public IteratorWeapon getIterator();
}
