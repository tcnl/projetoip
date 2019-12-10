package rcs8tcnl.repository.people;

import rcs8tcnl.basics.People;

public class PeopleRepositoryArray implements PeopleInterface, IteratorPeople {
	private People[] people;
	private People[] arrayIt;
	private int index;
	private int indexIterator;

	public PeopleRepositoryArray() {
		this.people = new People[0];
		this.index = 0;
	}

	public PeopleRepositoryArray(People[] array) {
		this.arrayIt = new People[array.length];
		for (int i = 0; i < array.length; i++) {
			this.arrayIt[i] = array[i];
		}
		this.indexIterator = 0;
	}

	public void insert(People people) {
		People[] aux = new People[this.people.length + 1];
		for (int i = 0; i < index; i++) {
			aux[i] = this.people[i];
		}
		aux[index] = people;
		this.people = aux;
		index++;
	}

	public void update(String dogTag, People people) {
		for (int i = 0; i < index; i++) {
			if (this.people[i].getDogtag().equalsIgnoreCase(dogTag)) {
				this.people[i] = people;
			}
		}
	}

	public void remove(String dogTag) {
		for (int i = 0; i < index; i++) {
			if (this.people[i].getDogtag().equalsIgnoreCase(dogTag)) {
				this.people[i] = null;
				this.people[i] = this.people[index - 1];
				index--;
			}
		}
	}

	public People search(String dogTag) {
		People aux = null;
		for (int i = 0; i < index && (aux == null); i++) {
			if (this.people[i] != null) {
				if (this.people[i].getDogtag().equalsIgnoreCase(dogTag)) {
					aux = this.people[i];
				}
			}
		}
		return aux;
	}

	public boolean hasNext() {
		return indexIterator < arrayIt.length;
	}

	public People next() {
		return arrayIt[indexIterator++];
	}

	public IteratorPeople getIterator() {
		return new PeopleRepositoryArray(this.people);
	}

}
