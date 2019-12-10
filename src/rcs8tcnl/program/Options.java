package rcs8tcnl.program;

public class Options {

	public String weaponChoice(int option) {
		String weaponName = null;
		switch (option) {
		case 1:
			weaponName = "Gauss Rifle";
			break;
		case 2:
			weaponName = "Fat Man";
			break;
		case 3:
			weaponName = "Power Armor";
			break;
		case 4:
			weaponName = "Flame Thrower";
			break;
		case 5:
			weaponName = "Plasma Rifle";
			break;
		case 6:
			weaponName = "Minigun";
			break;
		case 7:
			weaponName = "Submachine Gun";
			break;
		default:
			weaponName = "Pipe Pistol";
		}

		return weaponName;
	}

	public String weaponMenu() {
		return "1- Gauss Rifle \n 2- Fat Man \n 3- Power Armor \n  4- Flame Thrower \n 5- Plasma Rifle \n 6- Minigun \n 7- Submachine Gun";
	}

	public String drugChoice(int option) {
		String type = null;
		switch (option) {
		case 1:
			type = "RadAway";
			break;
		case 2:
			type = "Nuka Cola Quantum";
			break;
		case 3:
			type = "Med-X";
			break;
		case 4:
			type = "Psycho";
			break;
		case 5:
			type = "Buffout";
			break;
		case 6:
			type = "Mentats";
			break;
		case 7:
			type = "Jet";
			break;
		default:
			type = "LOL";
			break;
		}
		return type;
	}

	public String drugMenu() {
		return "1- RadAway \n 2- Nuka Cola Quantum \n 3- Med-X \n 4- Psycho \n 5- Buffout \n 6- Mentats \n 7- Jet";
	}

	public String deathChoice(int option) {
		String death = null;
		switch (option) {
		case 1:
			death = "Assassinado";
			break;
		case 2:
			death = "Bala perdida";
			break;
		case 3:
			death = "Enforcado por traicao";
			break;
		case 4:
			death = "Morto por um prisioneiro";
			break;
		case 5:
			death = "Executado";
			break;
		case 6:
			death = "Fome";
			break;
		default:
			death = "Bateu a cabeca";
			break;
		}
		return death;
	}

	public String deathMenu() {
		return "1- Assassinado \n 2- Bala Perdida \n 3- Enforcado por traicao \n 4- Morto por um prisioneiro\n 5- Executado \n 6- Bateu a cabeca";
	}

	public String factionChoice(int option) {
		String faction = null;
		switch (option) {
		case 1:
			faction = "Brotherhood of Steel";
			break;
		case 2:
			faction = "Gunners";
			break;
		case 3:
			faction = "Institute";
			break;
		case 4:
			faction = "Raiders";
			break;
		default:
			faction = "Institute";
			break;
		}
		return faction;
	}

	public String factionMenu() {
		return "1- Brotherhood of Steel \n 2- Gunners \n 3- Institute \n 4- Raiders";
	}

	public String firstMenu() {
		return "1- Prisioneiro \n2- Soldado \n3- Drogas \n4- Companion \n5- Armas \n6- Lucro Geral \n7- Sair";
	}

	public String prisonerMenu() {
		return "1- Adicionar Prisioneiro \n2- Matar Prisioneiro \n3- Cozinhar Drogas \n4- Procurar Prisioneiro \n5- Trabalhar \n6- Relatorio \n7- Voltar";
	}
}
