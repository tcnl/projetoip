package rcs8tcnl.basics;

public abstract class MoneyIncome {
	private double money;
	private String iD;

	public MoneyIncome(String iD) {
		this.money = 0;
		this.iD = iD;
	}

	public abstract void endYear();

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money += money;
	}

	public String getID() {
		return this.iD;
	}

	public void setID(String iD) {
		this.iD = iD;
	}

}