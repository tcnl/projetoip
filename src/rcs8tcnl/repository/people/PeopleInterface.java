package rcs8tcnl.repository.people;

import java.io.IOException;

import rcs8tcnl.basics.People;

public interface PeopleInterface {

	public void insert(People people) throws IOException;

	public void update(String dogTag, People people) throws IOException;

	public void remove(String dogTag) throws IOException;

	public People search(String dogTag);
	
	public boolean hasNext();

	public People next();

	public IteratorPeople getIterator();
}
