package rcs8tcnl.basics;


public class Army extends People {

	private String gun; // Arma de cada soldado
	private String causeDeath;

	public Army(String name, int age, double foodCost, int workHours, String dogtag, boolean status, String gun) {
		super(name, age, foodCost, workHours, dogtag, status);
		this.gun = gun;
	}

	public String getKilled() {
		String kia = "Numero da Dogtag: " + super.getDogtag() + "\n" + "Nome: " + super.getName() + "\n" + "Idade: "
				+ super.getAge() + "\n" + "Causa da morte: " + this.getCauseDeath();
		return kia;
	}

	public String getWeapon() {
		return this.gun;
	}

	public void setWeapon(Weapon gun) {
		this.gun = gun.getName();
	}

	public String getInfo() {
		String info = " Nome: " + super.getName() + "\n" + " Idade: " + super.getAge() + "\n"
				+ " Custo de alimentacao: " + super.getFoodCost() + "\n" + " Status: " + super.getStatus() + "\n"
				+ " Horas servidas a causa: " + super.getWorkHours() + "\n" + " Identificador: " + super.getDogtag()
				+ "\n" + " Arma Utilizada: " + this.gun + "\n" + "\n";
		return info;
	}

	public String getCauseDeath() {
		return this.causeDeath;
	}

	public void setCauseDeath(String causeDeath) {
		this.causeDeath = causeDeath;
	}

	public Army armyClone() {
		String name2 = super.getName();
		int age2 = super.getAge();
		double foodCost2 = super.getFoodCost();
		int workHours2 = super.getWorkHours();
		String dogTag2 = super.getDogtag();
		boolean status2 = super.getStatus();
		String gun2 = this.gun;
		String causeDeath2 = this.getCauseDeath();
		Army clone = new Army(name2, age2, foodCost2, workHours2, dogTag2, status2, gun2);
		clone.setCauseDeath(causeDeath2);
		return clone;
	}

}
