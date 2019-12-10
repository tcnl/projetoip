package rcs8tcnl.basics;

public class Companion extends MoneyIncome {
	private double shiftCost;
	private double foodCost;
	private int shiftHours;
	private double lifetimeEarnings;
	private double drugsSold;
	private String name;
	private int age;

	public Companion(String iD, String name, int age, double foodCost, int shiftHours, double shiftCost) {
		super(iD);
		super.setMoney(0);
		this.name = name;
		this.age = age;
		this.foodCost = foodCost;
		this.shiftHours = shiftHours;
		this.shiftCost = shiftCost;
		this.lifetimeEarnings = 0;
		this.drugsSold = 0;
	}

	public void giveFood(double quantity) {
		super.setMoney(-1 * (quantity * foodCost));
		this.setLifetimeEarnings(-1 * (quantity * foodCost));
	}

	public String sell() {
		double income;
		if (this.age > 18) {
			income = shiftHours * getShiftCost();
			super.setMoney(income);
			this.lifetimeEarnings += income;
			this.endYear();
		} else if(this.age > 12) {
			income = (shiftHours * getShiftCost()) * (115 / 100);
			super.setMoney(income);
			this.lifetimeEarnings += income;
			this.endYear();
		}
		String info = this.PleasureInfo();
		return info;
	}

	public Drugs sellDrugsClient(Drugs drug, double weight) {
		double income = drug.sellDrugs(weight);
		drug.setWeight(-weight);
		this.drugsSold += weight;
		this.lifetimeEarnings += income;
		super.setMoney(income);
		return drug;
	}

	public String giveHappyEnding(int hours) {
		double income = this.getShiftCost() * hours;
		super.setMoney(income);
		this.lifetimeEarnings += income;
		this.shiftHours += hours;
		return "$" + income + " foram adicionados ao banco da causa.";
	}

	public void endYear() {
		double yearProfit = super.getMoney();
		super.setMoney(0);
	}

	public String PleasureInfo() {
		String info = "Nome: " + this.name + "\n" + "Idade: " + this.getAge() + "\n" + "ID: " + super.getID() + "\n"
				+ "Horas de trabalho: " + this.shiftCost + "\n" + "Quantidade de drogas vendidas: " + this.drugsSold
				+ "\n" + "Faturamento do Ano: " + super.getMoney() + "\n" + "Faturamento geral: "
				+ this.lifetimeEarnings;
		return info;
	}

	public double getShiftCost() {
		return this.shiftCost;
	}

	public void setShiftCost(double shiftCost) {
		this.shiftCost = shiftCost;
	}

	public double getFoodCost() {
		return this.foodCost;
	}

	public void setFoodCost(double foodCost) {
		this.foodCost = foodCost;
	}

	public int getShiftHours() {
		return this.shiftHours;
	}

	public void setShiftHours(int hours) {
		this.shiftHours += hours;
	}

	public double getLifetimeEarnings() {
		return this.lifetimeEarnings;
	}

	public void setLifetimeEarnings(double money) {
		this.lifetimeEarnings += money;
	}

	public double getDrugsSold() {
		return this.drugsSold;
	}

	public void setDrugsSold(double weight) {
		this.drugsSold += weight;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Companion companionClone() {
		String iD2 = super.getID();
		String name2 = this.getName();
		int age2 = this.getAge();
		double foodCost2 = this.getFoodCost();
		int shiftHours2 = this.getShiftHours();
		double shiftCost2 = this.getShiftCost();
		double lifetimeEarnings2 = this.getLifetimeEarnings();
		double drugsSold2 = this.getDrugsSold();
		Companion clone = new Companion(iD2, name2, age2, foodCost2, shiftHours2, shiftCost2);
		clone.setLifetimeEarnings(lifetimeEarnings2);
		clone.setDrugsSold(drugsSold2);
		return clone;
	}

}
