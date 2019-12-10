package rcs8tcnl.repository.people;

import rcs8tcnl.basics.People;

public interface IteratorPeople {
	public boolean hasNext();

	public People next();

	public IteratorPeople getIterator();
}
