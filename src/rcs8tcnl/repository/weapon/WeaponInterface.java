package rcs8tcnl.repository.weapon;

import java.io.IOException;

import rcs8tcnl.basics.Weapon;

public interface WeaponInterface {

	public void insert(Weapon gun) throws IOException;

	public void update(String serial, Weapon gun) throws IOException;

	public void remove(String serial) throws IOException;

	public Weapon search(String serial);
	
	public boolean hasNext();

	public Weapon next();

	public IteratorWeapon getIterator();
}
