package rcs8tcnl.basics;

public class Weapon {

	private String name;
	private String serial;
	private int maxRounds;
	private int bullets;

	public Weapon(String serial, String name, int maxRounds, int bullets) {
		this.name = name;
		this.serial = serial;
		this.maxRounds = maxRounds;
		this.bullets = bullets;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public int getMaxRounds() {
		return this.maxRounds;
	}

	public void setMaxRounds(int maxRounds) {
		this.maxRounds = maxRounds;
	}

	public int getBullets() {
		return this.bullets;
	}

	public void setBullets(int bullets) {
		this.bullets += bullets;
	}

	public String WeaponInfo() {
		String weaponInfo = "Nome: " + this.getName() + "\n" + "Serial: " + this.getSerial() + "\n"
				+ "Quantidade de balas por pente: " + this.getMaxRounds() + "\n" + "Balas disponiveis para o soldado: "
				+ this.bullets;
		return weaponInfo;
	}
	
	public Weapon cloneWeapon(){
		String name2 = this.getName();
		String serial2 = this.getSerial();
		int maxRounds2 = this.getMaxRounds();
		int bullets2 = this.getBullets();
		Weapon clone = new Weapon(name2,serial2, maxRounds2, bullets2);
		return clone;		
	}

}
