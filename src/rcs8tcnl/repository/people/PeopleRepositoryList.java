package rcs8tcnl.repository.people;

import rcs8tcnl.basics.Army;
import rcs8tcnl.basics.People;
import rcs8tcnl.basics.Prisoner;

public class PeopleRepositoryList implements PeopleInterface, IteratorPeople {
	private People people;
	private PeopleRepositoryList next;

	public PeopleRepositoryList() {
		this.people = null;
		this.next = null;
	}

	public PeopleRepositoryList(People people, PeopleRepositoryList next) {
		if (people instanceof Army) {
			this.people = ((Army) people).armyClone();
		} else if (people instanceof Prisoner) {
			this.people = ((Prisoner) people).clonePrisoner();
		}
		if (next != null) {
			this.next = new PeopleRepositoryList(next.people, next.next);
		}
	}

	public void insert(People people) {
		if (this.people == null) {
			this.people = people;
		} else {
			if (next == null) {
				this.next = new PeopleRepositoryList();
			}
			this.next.insert(people);
		}
	}

	public void update(String dogTag, People people) {
		if (this.people.getDogtag().equalsIgnoreCase(dogTag)) {
			this.people = people;
		} else {
			this.next.update(dogTag, people);
		}

	}

	public void remove(String dogTag) {
		if (this.people.getDogtag().equalsIgnoreCase(dogTag)) {
			if (next != null) {
				this.people = this.next.people;
				this.next = this.next.next;
			} else {
				this.people = null;
			}
		} else {
			this.next.remove(dogTag);
		}

	}

	public People search(String dogTag) {
		People aux = null;
		if (this.people != null) {
			if (this.people.getDogtag().equals(dogTag) && aux == null) {
				aux = this.people;
			} else {
				if (this.next != null) {
					aux = this.next.search(dogTag);
				}
			}
		}
		return aux;
	}

	public boolean hasNext() {
		return (people != null);
	}

	public People next() {
		People people = this.people;
		if (next != null) {
			next = next.next;
		}
		return people;
	}

	public IteratorPeople getIterator() {
		return new PeopleRepositoryList(this.people, this.next);
	}
}
