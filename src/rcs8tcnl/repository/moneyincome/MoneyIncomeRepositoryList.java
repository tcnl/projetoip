package rcs8tcnl.repository.moneyincome;

import rcs8tcnl.basics.Companion;
import rcs8tcnl.basics.Drugs;
import rcs8tcnl.basics.MoneyIncome;

public class MoneyIncomeRepositoryList implements MoneyIncomeInterface, IteratorMoneyIncome {
	private MoneyIncome money;
	private MoneyIncomeRepositoryList next;

	public MoneyIncomeRepositoryList() {
		this.money = null;
		this.next = null;
	}

	public MoneyIncomeRepositoryList(MoneyIncome money, MoneyIncomeRepositoryList next) {
		if (money instanceof Companion) {
			this.money = ((Companion) money).companionClone();
		} else if (money instanceof Drugs) {
			this.money = ((Drugs) money).drugClone();
		}
		if (next != null) {
			this.next = new MoneyIncomeRepositoryList(next.money, next.next);
		}
	}

	public void insert(MoneyIncome money) {
		if (this.money == null) {
			this.money = money;
		} else {
			if (this.next == null) {
				this.next = new MoneyIncomeRepositoryList();
			}
			this.next.insert(money);
		}
	}

	public void update(String iD, MoneyIncome money) {
		if (this.money.getID().equalsIgnoreCase(iD)) {
			this.money = money;
		} else {
			this.next.update(iD, money);
		}

	}

	public void remove(String iD) {
		if (this.money.getID().equalsIgnoreCase(iD)) {
			if (this.next != null) {
				this.money = this.next.money;
				this.next = this.next.next;
			} else {
				this.money = null;
			}
		} else {
			this.next.remove(iD);
		}

	}

	public MoneyIncome search(String iD) {
		MoneyIncome aux = null;
		if (this.money != null) {
			if (this.money.getID().equalsIgnoreCase(iD)) {
				aux = this.money;
			} else {
				if (next != null) {
					aux = this.next.search(iD);
				}
			}
		}
		return aux;
	}

	public boolean hasNext() {
		return (this.money != null);
	}

	public MoneyIncome next() {
		MoneyIncome money = this.money;
		if (next != null) {
			next = next.next;
		}
		return money;
	}

	public IteratorMoneyIncome getIterator() {
		return new MoneyIncomeRepositoryList(this.money, this.next);
	}
}
