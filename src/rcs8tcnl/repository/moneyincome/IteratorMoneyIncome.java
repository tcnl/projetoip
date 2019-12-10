package rcs8tcnl.repository.moneyincome;

import rcs8tcnl.basics.MoneyIncome;

public interface IteratorMoneyIncome {
	public boolean hasNext();

	public MoneyIncome next();

	public IteratorMoneyIncome getIterator();
}
