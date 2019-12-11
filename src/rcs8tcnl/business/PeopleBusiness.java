package rcs8tcnl.business;

import java.io.IOException;
import java.util.Arrays;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import rcs8tcnl.basics.Army;
import rcs8tcnl.basics.People;
import rcs8tcnl.basics.Prisoner;
import rcs8tcnl.exceptions.*;
import rcs8tcnl.repository.people.IteratorPeople;
import rcs8tcnl.repository.people.PeopleInterface;

import org.aspectj.lang.*;

@Aspect
class MyAspect {
	@Before("execution(* rcs8tcnl.business.PeopleBusiness.*(..)")
	public void before(JoinPoint joinPoint){
		System.out.print("Antes do metodo: ");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* rcs8tcnl.business.PeopleBusiness.*(..)", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		System.out.println(joinPoint.getSignature().getName() + " Retornou: " + result);
	}

}

public class PeopleBusiness {

	private PeopleInterface people;

	public PeopleBusiness(PeopleInterface rep) {
		this.people = rep;
	}

	public void insert(People person) throws IOException,
			PersonAlreadyExistsException {
		People aux = people.search(person.getDogtag());
		if (aux == null) {
			this.people.insert(person);
		} else {
			throw new PersonAlreadyExistsException();
		}
	}

	public void update(String dogTag, People person) throws IOException,
			InvalidUpdateException, MissingUpdateException, PersonNotFoundException {
		People aux = people.search(dogTag);
		if (aux != null) {
			if (aux instanceof Army && person instanceof Prisoner
					|| aux instanceof Prisoner && person instanceof Army) {
				throw new InvalidUpdateException();
			} else {
				people.update(dogTag, person);
			}
		} else {
			throw new PersonNotFoundException();
		}

	}

	public void remove(String dogTag) throws PersonNotFoundException,
			IOException {
		People aux = people.search(dogTag);
		if (aux == null) {
			throw new PersonNotFoundException();
		} else {
			people.remove(dogTag);
		}
	}

	public People search(String dogTag) throws PersonNotFoundException {
		People aux = people.search(dogTag);
		if (aux == null) {
			throw new PersonNotFoundException();
		} else {
			return aux;
		}
	}

	public boolean hasNext() {
		return people.hasNext();
	}

	public People next() {
		return people.next();
	}

	public IteratorPeople getIterator() {
		return people.getIterator();
	}

}
