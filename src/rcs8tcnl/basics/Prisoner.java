package rcs8tcnl.basics;

import java.util.Random;

public class Prisoner extends People {
	private double drugsCooked;
	private String causeDeath;

	public Prisoner(String name, int age, double foodCost, int workHours,
			String dogtag, boolean status) {
		super(name, age, foodCost, workHours, dogtag, status);
		super.setStatus(true);
		this.drugsCooked = 0;
		this.causeDeath = "Nenhuma.";
	}

	public String getKilled() {
		String finalinfo = "Nome: " + super.getName() + "\n" + "Idade: "
				+ super.getAge() + "\n" + "Numero de Identifica��o: "
				+ super.getDogtag() + "\n" + "Causa da morte: "
				+ this.getCauseDeath() + "\n";
		return finalinfo;
	}

	public double getDrugsCooked() {
		return this.drugsCooked;
	}

	public void setDrugsCooked(double drugsCooked) {
		this.drugsCooked += drugsCooked;
	}

	public Drugs letsCookBitch(Drugs drug, double weight, int hours) {
		Random generator = new Random();
		boolean cooked = generator.nextBoolean();
		if (cooked == true) {
			this.setDrugsCooked(weight);
			drug.setWeight(weight);
			this.setWorkHours(hours);
			return drug;
		} else {
			return null;
		}
	}

	public String getInfo() {
		String prisonerInfo = "Nome: " + super.getName() + "\n" + "Idade: "
				+ super.getAge() + "\n" + "DogTag: " + super.getDogtag() + "\n"
				+ "Custo: " + super.getFoodCost() + "\n"
				+ "Horas Trabalhadas: " + super.getWorkHours() + "\n"
				+ "Quantidade de Drogas Produzidas: " + this.getDrugsCooked();
		return prisonerInfo;
	}

	public String getCauseDeath() {
		return this.causeDeath;
	}

	public void setCauseDeath(String causeDeath) {
		this.causeDeath = causeDeath;
	}

	public Prisoner clonePrisoner() {
		String name2 = super.getName();
		int age2 = super.getAge();
		double foodCost2 = super.getFoodCost();
		int workHours2 = super.getWorkHours();
		String dogTag2 = super.getDogtag();
		boolean status2 = super.getStatus();
		double drugsCooked2 = this.getDrugsCooked();
		String causeDeath2 = this.getCauseDeath();
		Prisoner clone = new Prisoner(name2, age2, foodCost2, workHours2,
				dogTag2, status2);
		clone.setCauseDeath(causeDeath2);
		return clone;
	}

}
