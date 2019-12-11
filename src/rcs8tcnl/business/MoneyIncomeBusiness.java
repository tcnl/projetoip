package rcs8tcnl.business;

import java.io.IOException;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import rcs8tcnl.basics.Drugs;
import rcs8tcnl.basics.MoneyIncome;
import rcs8tcnl.basics.Companion;
import rcs8tcnl.repository.moneyincome.IteratorMoneyIncome;
import rcs8tcnl.repository.moneyincome.MoneyIncomeInterface;
import rcs8tcnl.exceptions.*;

@Aspect
class MoneyAspect {
	@Before("execution(* rcs8tcnl.business.MoneyIncomeBusiness.*(..)")
	public void before(JoinPoint joinPoint){
		System.out.print("Antes do metodo: ");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* rcs8tcnl.business.MoneyIncomeBusiness.*(..)", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result){
		System.out.println(joinPoint.getSignature().getName() + " Retornou: " + result);
	}

}

public class MoneyIncomeBusiness {
	private MoneyIncomeInterface money;

	public MoneyIncomeBusiness(MoneyIncomeInterface rep) {
		this.money = rep;
	}

	public void insert(MoneyIncome type) throws IOException,
			IdAlreadyExistsException, IdNotFoundException {
		MoneyIncome aux = money.search(type.getID());
		if (type instanceof Companion) {
			if (aux == null) {
				money.insert(type);
			} else {
				throw new IdAlreadyExistsException();
			}
		} else if (type instanceof Drugs) {
			if (aux == null) {
				money.insert(type);
			} else {
				((Drugs) aux).setWeight(((Drugs) type).getWeight());
				money.update(type.getID(), aux);
			}
		}
	}

	public void update(String iD, MoneyIncome type) throws IOException,
			InvalidUpdateException, MissingUpdateException {
		MoneyIncome aux = money.search(iD);
		if (aux != null) {
			if (aux instanceof Companion && type instanceof Drugs
					|| aux instanceof Drugs && type instanceof Companion) {
				throw new InvalidUpdateException();
			} else {
				money.update(iD, type);
			}
		} else {
			throw new MissingUpdateException();
		}
	}

	public void remove(String iD) throws IdNotFoundException, IOException {
		MoneyIncome aux = money.search(iD);
		if (aux != null) {
			money.remove(iD);
		} else {
			throw new IdNotFoundException();
		}
	}

	public MoneyIncome search(String iD) throws IdNotFoundException {
		MoneyIncome aux = money.search(iD);
		if (aux == null) {
			throw new IdNotFoundException();
		} else {
			return aux;
		}
	}

	public boolean hasNext() {
		return money.hasNext();
	}

	public MoneyIncome next() {
		return money.next();
	}

	public IteratorMoneyIncome getIterator() {
		return money.getIterator();
	}

}
