package rcs8tcnl.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.aspectj.lang.annotation.After;
import org.jetbrains.annotations.NotNull;
import rcs8tcnl.business.*;
import rcs8tcnl.basics.*;
import rcs8tcnl.exceptions.*;
import rcs8tcnl.program.Teste;
import rcs8tcnl.program.WarlordGUI;
import rcs8tcnl.repository.moneyincome.*;
import rcs8tcnl.repository.people.*;
import rcs8tcnl.repository.weapon.*;

import java.util.Formatter;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "rcs8tcnl.front" })
class SpringContextAOP {
}
//Adding Aspect
@Aspect
@Component
class MyAspect {
	//Point cuts
	@Before("execution(* rcs8tcnl.front.TheEmpireBusiness.*(..)")
	//Weavings
	public void before(@NotNull JoinPoint joinPoint){
		System.out.print("Antes do metodo: ");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	@After("execution(* rcs8tcnl.front.TheEmpireBusiness.*(..)")
	public void after(@NotNull JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName() + " Retornou: ");
	}

}


@ContextConfiguration(classes = TheEmpireBusiness.class)


public class TheEmpireBusiness {
	private MoneyIncomeBusiness money;
	private PeopleBusiness people;
	private WeaponBusiness arsenal;
	private double profit;
	private int deadPrisoners;
	private int deadArmy;
	private int capturedPrisoners;
	private char rep;

	public TheEmpireBusiness() throws IOException {
		File config = new File(WarlordGUI.CONFIG_TXT_REPOSITORY);
		FileInputStream in = new FileInputStream(config);
		rep = (char) in.read();
		if (!config.exists()) {
			config.createNewFile();
		}
		if (rep == 'a' || rep == 'A') {
			this.money = new MoneyIncomeBusiness(
					new MoneyIncomeRepositoryArray());
			this.people = new PeopleBusiness(new PeopleRepositoryArray());
			this.arsenal = new WeaponBusiness(new WeaponRepositoryArray());
		} else if (rep == 'f' || rep == 'F') {
			this.money = new MoneyIncomeBusiness(
					new MoneyIncomeRepositoryFile());
			this.people = new PeopleBusiness(new PeopleRepositoryFile());
			this.arsenal = new WeaponBusiness(new WeaponRepositoryFile());
		} else if (rep == 'l' || rep == 'L') {
			this.money = new MoneyIncomeBusiness(
					new MoneyIncomeRepositoryList());
			this.people = new PeopleBusiness(new PeopleRepositoryList());
			this.arsenal = new WeaponBusiness(new WeaponRepositoryList());
		}
		this.deadArmy = 0;
		this.deadPrisoners = 0;
		this.capturedPrisoners = 0;
		in.close();
	}

	// Inserir das classes
	public void insertPeople(People person) throws IOException,
			PersonAlreadyExistsException {
		this.people.insert(person);
		if (person instanceof Prisoner) {
			this.capturedPrisoners++;
		}
	}

	public void insertIncome(MoneyIncome income) throws IOException,
			IdAlreadyExistsException, IdNotFoundException {
		this.money.insert(income);
	}

	public void insertWeapon(Weapon gun) throws IOException,
			SerialAlreadyExistsException {
		this.arsenal.insert(gun);
	}

	// Atualizar Das Classes
	public void workArmy(String dogTag, int hours)
			throws PersonNotFoundException, IOException,
			InvalidUpdateException, MissingUpdateException,
			PrisonerArmyException {
		People aux = this.people.search(dogTag);
		if (aux instanceof Prisoner) {
			throw new PrisonerArmyException();
		} else {
			aux.setWorkHours(hours);
			this.people.update(dogTag, aux);
		}
	}

	public void workPrisonerCookDrugs(String dogTag, String iD, double weight,
			String faction, int hours) throws PersonNotFoundException,
			ArmyCantCookException, IdNotFoundException,
			JessieUsedTheDrugsException, IOException, InvalidUpdateException,
			MissingUpdateException, CompanionDrugFoundException {
		People aux = this.people.search(dogTag);
		MoneyIncome off = this.money.search(iD);
		if (aux instanceof Army) {
			throw new ArmyCantCookException();
		} else {
			if (off instanceof Drugs) {
				Drugs cook = ((Prisoner) aux).letsCookBitch((Drugs) off,
						weight, hours);
				if (cook != null) {
					this.money.update(iD, cook);
					this.people.update(dogTag, aux);
				} else {
					throw new JessieUsedTheDrugsException();
				}
			} else {
				throw new CompanionDrugFoundException();
			}
		}
	}

	public void sellDrugs(String iD, double weight, String faction)
			throws IdNotFoundException, CompanionDrugFoundException,
			IOException, InvalidUpdateException, MissingUpdateException {
		MoneyIncome off = this.money.search(iD);
		if (off instanceof Drugs) {
			if (faction.equals("Raiders")) {
				((Drugs) off).setRaid(weight);
			} else if (faction.equals("Brotherhood of Steel")) {
				((Drugs) off).setBOS(weight);
			} else if (faction.equals("Gunners")) {
				((Drugs) off).setG(weight);
			} else if (faction.equals("Institute")) {
				((Drugs) off).setCIT(weight);
			}
			((Drugs) off).setWeight(-weight);
			this.money.update(iD, off);

		} else if (off instanceof Companion) {
			throw new CompanionDrugFoundException();
		}
	}

	public void workCompanionSellDrugs(String type, double weight, String iD,
			String faction) throws IdNotFoundException,
			DrugsCompanionFoundException, CompanionDrugFoundException,
			IOException, InvalidUpdateException, MissingUpdateException {
		MoneyIncome aux = this.money.search(iD);
		MoneyIncome off = this.money.search(type);
		if (aux instanceof Drugs) {
			throw new DrugsCompanionFoundException();
		} else if (aux instanceof Companion) {
			if (off instanceof Drugs) {
				Drugs cook = ((Companion) aux).sellDrugsClient((Drugs) off,
						weight);
				if (faction.equals("Raiders")) {
					((Drugs) cook).setRaid(weight);
				} else if (faction.equals("Brotherhood of Steel")) {
					((Drugs) cook).setBOS(weight);
				} else if (faction.equals("Gunners")) {
					((Drugs) cook).setG(weight);
				} else if (faction.equals("Institute")) {
					((Drugs) cook).setCIT(weight);
				}
				this.money.update(iD, aux);
				this.money.update(type, cook);

			} else if (off instanceof Companion) {
				throw new CompanionDrugFoundException();
			}
		}
	}

	public void workCompanionGiveMassage(int hours, String iD)
			throws IdNotFoundException, DrugsCompanionFoundException,
			IOException, InvalidUpdateException, MissingUpdateException {
		MoneyIncome aux = this.money.search(iD);
		if (aux instanceof Drugs) {
			throw new DrugsCompanionFoundException();
		} else if (aux instanceof Companion) {
			((Companion) aux).giveHappyEnding(hours);
			this.money.update(iD, aux);
		}
	}

	public void addBullets(String serial, int bullets)
			throws WeaponNotFoundException, MissingUpdateException, IOException {
		Weapon aux = this.arsenal.search(serial);
		aux.setBullets(bullets);
		this.arsenal.update(serial, aux);

	}

	// Procurar das Classes
	public People searchPerson(String dogTag) throws PersonNotFoundException {
		return this.people.search(dogTag);
	}

	public MoneyIncome searchIncome(String iD) throws IdNotFoundException {
		return this.money.search(iD);
	}

	public Weapon searchGun(String serial) throws WeaponNotFoundException {
		return this.arsenal.search(serial);
	}

	// Remover das Classes
	public void removePerson(String dogTag) throws PersonNotFoundException,
			IOException {
		People aux = this.people.search(dogTag);
		people.remove(dogTag);
		if (aux instanceof Army) {
			this.deadArmy++;
		} else if (aux instanceof Prisoner) {
			this.deadPrisoners++;
		}
	}

	public void removeIncome(String iD) throws IdNotFoundException, IOException {
		this.money.remove(iD);
	}

	public void removeGun(String serial) throws WeaponNotFoundException,
			IOException {
		this.arsenal.remove(serial);
	}

	// reports
	public String reportArmy() throws IOException {
		String report = "";
		Formatter exit = new Formatter(WarlordGUI.TXT_ARMY);
		int c = 0;
		IteratorPeople it = this.people.getIterator();
		while (it.hasNext()) {
			People aux = it.next();
			if (aux != null) {
				if (aux instanceof Army) {
					profit -= ((Army) aux).getFoodCost();
					report += ((Army) aux).getInfo() + "\n";
					exit.format(c + "- " + ((Army) aux).getInfo() + "\n");
					c++;
				}
			}
		}
		exit.format("Numeros de prisioneiros capturados: "
				+ this.capturedPrisoners + "\n");
		exit.format("Numeros de soldados mortos: " + this.deadArmy + "\n");
		report += "Numeros de prisioneiros capturados: "
				+ this.capturedPrisoners + "\n";
		report += "Soldados mortos: " + this.deadArmy + "\n";
		exit.close();
		return report;
	}

	public String reportPrisoner() throws FileNotFoundException {
		String report = "";
		Formatter exit = new Formatter(WarlordGUI.TXT_PRISONER);
		double totalDrugsCooked = 0;
		IteratorPeople it = this.people.getIterator();
		while (it.hasNext()) {
			People aux = it.next();
			if (aux != null) {
				if (aux instanceof Prisoner) {
					profit -= ((Prisoner) aux).getFoodCost();
					totalDrugsCooked += ((Prisoner) aux).getDrugsCooked();
					report += ((Prisoner) aux).getInfo() + "\n";
					exit.format(((Prisoner) aux).getInfo() + "\n");
				}
			}
		}
		exit.format("Total de drogas produzidas: " + totalDrugsCooked + "\n");
		exit.format("Numeros de prisioneiros mortos: " + this.deadPrisoners
				+ "\n");
		report += "Total de drogas produzidas: " + totalDrugsCooked + "\n";
		report += "Prisioneiros mortos: " + this.deadPrisoners + "\n";
		exit.close();
		return report;
	}

	public String endYearDrugs() throws FileNotFoundException {
		String report = "";
		Formatter exit = new Formatter(WarlordGUI.TXT_INCOME);
		double lifeEarnings = 0;
		double money = 0;
		double bos = 0;
		double cit = 0;
		double gun = 0;
		double rai = 0;
		double biggest = 0;
		String bestDrug = "";
		IteratorMoneyIncome it = this.money.getIterator();
		while (it.hasNext()) {
			MoneyIncome aux = it.next();
			if (aux instanceof Drugs) {		
				money += ((Drugs) aux).getMoney();
				lifeEarnings += ((Drugs) aux).getLifetimeEarnings();
				bos += ((Drugs) aux).getBOS();
				cit += ((Drugs) aux).getCIT();
				gun += ((Drugs) aux).getG();
				rai += ((Drugs) aux).getRaid();
				double total = ((Drugs) aux).getBOS() + ((Drugs) aux).getCIT()
						+ ((Drugs) aux).getG() + ((Drugs) aux).getRaid();
				report += ((Drugs) aux).drugInfo() + "\n\n";
				exit.format(((Drugs) aux).drugInfo() + "\n");
				((Drugs)aux).endYear();
				if (total > biggest) {
					biggest = total;
					bestDrug = ((Drugs) aux).getID();
				}
			}
		}
		exit.format("\nMelhor droga: " + bestDrug + "\n");
		exit.format("Brotherhood of Steel: " + bos + "\nInstitute: " + cit
				+ "\nGunners: " + gun + "\nRaiders: " + rai + "\n");
		exit.format("Dinheiro do ano: Caps " + money);
		exit.format("Dinheiro ganho com drogas: Caps " + lifeEarnings);
		report += "Melhor droga: " + bestDrug + "\n";
		report += "Brotherhood of Steel: " + bos + "\nInstitute: " + cit
				+ "\nGunners: " + gun + "\nRaiders: " + rai + "\n";
		profit += lifeEarnings;
		exit.close();
		return report;
	}

	public String endYearCompanion() throws FileNotFoundException {
		String report = "";
		Formatter exit = new Formatter(WarlordGUI.TXT_COMPANION);
		int c = 0;
		double money = 0;
		double lifeEarnings = 0;
		double totalDrugsSold = 0;
		double biggest = 0;
		String bestCompanion = null;
		IteratorMoneyIncome it = this.money.getIterator();
		while (it.hasNext()) {
			MoneyIncome aux = it.next();
			if (aux instanceof Companion) {
				double yearMoney = ((Companion) aux).getMoney();
				double lifetimeEarnings = ((Companion) aux)
						.getLifetimeEarnings();
				lifeEarnings += lifetimeEarnings;
				if (lifetimeEarnings >= biggest) {
					biggest = lifetimeEarnings;
					bestCompanion = ((Companion) aux).getID();
				}

				totalDrugsSold += ((Companion) aux).getDrugsSold();
				aux.endYear();
				report += ((Companion) aux).PleasureInfo() + "\n\n";
				exit.format(c + "- " + ((Companion) aux).PleasureInfo() + "\n");
				c++;
			}
		}
		exit.format("Total de drogas vendidas: " + totalDrugsSold + "\n");
		exit.format("Melhor acompanhante: " + bestCompanion + "\n");
		exit.format("Dinheiro ganho no ano: Caps" + money + "\n");
		exit.format("Dinheiro ganho por acompanhantes: Caps" + lifeEarnings
				+ "\n");
		profit += lifeEarnings;
		report += "Total de drogas vendidas: " + totalDrugsSold + "\n";
		report += "Melhor acompanhante : " + bestCompanion + "\n";
		exit.close();
		return report;
	}

	public String reportProfit() throws IOException {
		this.endYearCompanion();
		this.endYearDrugs();
		this.reportArmy();
		this.reportPrisoner();
		Formatter exit = new Formatter(WarlordGUI.TXT_PROFIT);
		exit.format("Lucro geral produzido incluindo despesas: Caps "
				+ this.profit);

		return "Lucro geral: Caps " + this.profit;
	}
}
