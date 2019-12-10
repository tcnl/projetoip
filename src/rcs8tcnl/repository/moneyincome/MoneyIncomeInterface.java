package rcs8tcnl.repository.moneyincome;

import java.io.IOException;

import rcs8tcnl.basics.MoneyIncome;

public interface MoneyIncomeInterface {

	public void insert(MoneyIncome type) throws IOException;

	public void update(String iD, MoneyIncome type) throws IOException;

	public void remove(String iD) throws IOException;

	public MoneyIncome search(String iD);
	
	public boolean hasNext();

	public MoneyIncome next();

	public IteratorMoneyIncome getIterator();
}
