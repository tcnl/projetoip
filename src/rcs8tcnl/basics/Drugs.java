package rcs8tcnl.basics;

public class Drugs extends MoneyIncome {
	private double weight;
	private double priceQuilo;
	private double lifetimeEarnings;
	private double G;
	private double BOS;
	private double CIT;
	private double Raid;

	public Drugs(String type, double weight, double priceQuilo) {
		super(type);
		super.setMoney(0);
		this.weight = weight;
		this.priceQuilo = priceQuilo;
		this.lifetimeEarnings = 0;
		this.G = 0;
		this.BOS = 0;
		this.CIT = 0;
		this.Raid = 0;
	}

	public void endYear() {
		super.setMoney(0);
	}

	public double sellDrugs(double quilo) {
		double income = quilo * this.getPriceQuilo();
		this.setLifetimeEarnings(income);
		super.setMoney(income);
		this.setWeight(-quilo);
		return income;
	}

	public String drugInfo() {
		String drug = "Type: " + super.getID() + "\n" + "Peso: " + this.getWeight() + "\n" + "Preco por Quilo: "
				+ this.priceQuilo + "\n" + "Faturamento da Droga no Ano: " + super.getMoney() + "\n"
				+ "Faturamento Geral da Droga: " + this.getLifetimeEarnings() + "\n" + "Vendido para: " + "\n" + "BOS: "
				+ this.getBOS() + "\n" + "CIT: " + this.getCIT() + "\n" + "Gunners: " + this.getG() + "\n" + "Raiders: "
				+ this.getRaid() + "\n" + "\n";
		return drug;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight += weight;
	}

	public double getPriceQuilo() {
		return this.priceQuilo;
	}

	public void setPriceQuilo(double priceQuilo) {
		this.priceQuilo = priceQuilo;
	}

	public double getLifetimeEarnings() {
		return this.lifetimeEarnings;
	}

	public void setLifetimeEarnings(double lifetimeEarnings) {
		this.lifetimeEarnings += lifetimeEarnings;
	}

	public double getRaid() {
		return this.Raid;
	}

	public void setRaid(double raid) {
		Raid += raid;
	}

	public double getCIT() {
		return this.CIT;
	}

	public void setCIT(double cIT) {
		CIT += cIT;
	}

	public double getG() {
		return this.G;
	}

	public void setG(double g) {
		G += g;
	}

	public double getBOS() {
		return this.BOS;
	}

	public void setBOS(double bOS) {
		BOS += bOS;
	}

	public Drugs drugClone() {
		String type2 = super.getID();
		double weight2 = this.getWeight();
		double priceQuilo2 = this.getPriceQuilo();
		double lifetimeEarnings2 = this.lifetimeEarnings;
		double G2 = this.getG();
		double BOS2 = this.getBOS();
		double CIT2 = this.getCIT();
		double Raid2 = this.getRaid();
		Drugs clone = new Drugs(type2, weight2, priceQuilo2);
		clone.setLifetimeEarnings(lifetimeEarnings2);
		clone.setG(G2);
		clone.setBOS(BOS2);
		clone.setCIT(CIT2);
		clone.setRaid(Raid2);
		return clone;
	}
}
