package rcs8tcnl.basics;

public abstract class People {
	private String name;
	private int age;
	private double foodCost;
	private boolean status;
	private int workHours;
	private String dogtag;

	public People(String name, int age, double foodCost,
			int workHours, String dogtag, boolean status) {
		this.name = name;
		this.age = age;
		this.foodCost = foodCost;
		this.status = status;
		this.workHours = workHours;
		this.dogtag = dogtag;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public double getFoodCost() {
		return this.foodCost;
	}

	public void setFoodCost(double foodCost) {
		this.foodCost = foodCost;
	}

	public int getWorkHours() {
		return this.workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours += workHours;
	}

	public abstract String getKilled();

	public String getDogtag() {
		return this.dogtag;
	}

	public void setDogtag(String dogtag) {
		this.dogtag = dogtag;
	}
	
	public abstract String getInfo();

}
