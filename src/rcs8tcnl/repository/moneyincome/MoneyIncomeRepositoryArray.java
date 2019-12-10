package rcs8tcnl.repository.moneyincome;

import rcs8tcnl.basics.Drugs;
import rcs8tcnl.basics.MoneyIncome;
import rcs8tcnl.basics.Companion;

public class MoneyIncomeRepositoryArray implements MoneyIncomeInterface, IteratorMoneyIncome {
	private MoneyIncome[] incomeType;
	private MoneyIncome[] arrayIt;
	private int index;
	private int indexIterator;

	public MoneyIncomeRepositoryArray() {
		this.incomeType = new MoneyIncome[0];
		this.index = 0;
	}

	public MoneyIncomeRepositoryArray(MoneyIncome[] array) {
		this.arrayIt = new MoneyIncome[array.length];
		for (int i = 0; i < array.length; i++) {
			this.arrayIt[i] = array[i];
		}
		this.indexIterator = 0;
	}

	public void insert(MoneyIncome type) {
		MoneyIncome[] aux = new MoneyIncome[this.incomeType.length + 1];
		for (int i = 0; i < index; i++) {
			aux[i] = this.incomeType[i];
		}
		aux[index] = type;
		this.incomeType = aux;
		index++;
	}

	public void update(String iD, MoneyIncome type) {
		for (int i = 0; i < index; i++) {
			if (this.incomeType[i].getID().equalsIgnoreCase(iD)) {
				this.incomeType[i] = type;
			}
		}
	}

	public void remove(String iD) {
		for (int i = 0; i < index; i++) {
			if (this.incomeType[i].getID().equalsIgnoreCase(iD)) {
				this.incomeType[i] = null;
				this.incomeType[i] = this.incomeType[index - 1];
				index--;
			}
		}
	}

	public MoneyIncome search(String iD) {
		MoneyIncome aux = null;
		for (int i = 0; i < index && (aux == null); i++) {
			if (this.incomeType[i] != null) {
				if (this.incomeType[i].getID().equalsIgnoreCase(iD)) {
					aux = this.incomeType[i];
				}
			}
		}
		return aux;
	}

	public boolean hasNext() {
		return indexIterator < arrayIt.length;
	}

	public MoneyIncome next() {
		MoneyIncome next = arrayIt[indexIterator];
		this.indexIterator++;
		return next;
	}

	public IteratorMoneyIncome getIterator() {
		return new MoneyIncomeRepositoryArray(this.incomeType);
	}

}
