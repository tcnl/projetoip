package rcs8tcnl.program;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import rcs8tcnl.basics.Companion;
import rcs8tcnl.basics.Drugs;
import rcs8tcnl.basics.MoneyIncome;
import rcs8tcnl.exceptions.*;
import rcs8tcnl.front.TheEmpireBusiness;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Teste {
	public static final String FILES_SPREADSHEET = "Apache.xls";
	public static final String FILES_MONEYINCOME_SHEET = "Money";
	public static final String FILES_PEOPLE_SHEET = "People";
	public static final String FILES_WEAPONS_SHEET = "Weapon";
	public static final String CONFIG_TXT_REPOSITORY = "Config.txt";
	public static final String TXT_ARMY = "Army.txt";
	public static final String TXT_PRISONER = "Prisoner.txt";
	public static final String TXT_INCOME = "Income.txt";
	public static final String TXT_COMPANION = "Companion.txt";
	public static final String TXT_PROFIT = "Profit.txt";
	public static final String FILES_INDEX_SHEET = "Index";

	public static void main(String[] args) {
		try {
			File file = new File(FILES_SPREADSHEET);
			File config = new File(CONFIG_TXT_REPOSITORY);
			File army = new File(TXT_ARMY);
			File prisoner = new File(TXT_PRISONER);
			File companion = new File(TXT_COMPANION);
			File profit = new File(TXT_PROFIT);
			
			if (!file.exists()) {
				file.createNewFile();
				FileOutputStream exit = new FileOutputStream(file);
				Workbook workbook = new HSSFWorkbook();
				Sheet paper = workbook.createSheet(FILES_PEOPLE_SHEET);
				Row first = paper.createRow(0);
				first.createCell(0).setCellValue("Dogtag");
				first.createCell(1).setCellValue("Name");
				first.createCell(2).setCellValue("Age");
				first.createCell(3).setCellValue("Status");
				first.createCell(4).setCellValue("Custo Alimentar");
				first.createCell(5).setCellValue("Horas Trabalhadas");
				first.createCell(6).setCellValue("Atributo Pessoal");
				first.createCell(7).setCellValue("Tipo");

				paper = workbook.createSheet(FILES_MONEYINCOME_SHEET);
				first = paper.createRow(0);
				first.createCell(0).setCellValue("Tipo");
				first.createCell(1).setCellValue("ID");
				first.createCell(2).setCellValue("Lucro Ano");
				first.createCell(3).setCellValue("4");
				first.createCell(4).setCellValue("5");
				first.createCell(5).setCellValue("6");
				first.createCell(6).setCellValue("7");
				first.createCell(7).setCellValue("8");
				first.createCell(8).setCellValue("9");
				first.createCell(9).setCellValue("10");

				paper = workbook.createSheet(FILES_WEAPONS_SHEET);
				first = paper.createRow(0);
				first.createCell(0).setCellValue("Serial");
				first.createCell(1).setCellValue("Nome");
				first.createCell(2).setCellValue("Balas por pente");
				first.createCell(3).setCellValue("Balas restantes");
				
				paper = workbook.createSheet(FILES_INDEX_SHEET);
				first = paper.createRow(0);
				first.createCell(0).setCellValue(1);
				first.createCell(1).setCellValue(1);
				first.createCell(2).setCellValue(1);
				
				workbook.write(exit);
				exit.close();
				workbook.close();
			}
			if (!config.exists()) {
				config.createNewFile();
			}
			if (!army.exists()) {
				army.createNewFile();
			}
			if (!prisoner.exists()) {
				prisoner.createNewFile();
			}
			if (!companion.exists()) {
				companion.createNewFile();
			}			
			if (!profit.exists()) {
				profit.createNewFile();
			}
			
			Scanner in = new Scanner(System.in);
			Scanner st = new Scanner(System.in);
			TheEmpireBusiness ww = new TheEmpireBusiness();
			
			MoneyIncome d = new Drugs("Nuka Cola Quantum", 20, 29.99);
			ww.insertIncome(d);
			MoneyIncome dc = new Drugs("RadAway", 20, 29.99);
			ww.insertIncome(dc);
			ww.sellDrugs("RadAway", 5, "Brotherhood of Steel");
			MoneyIncome c = new Companion("Laila", "Larissa", 19, 20, 0, 1500.90);
			ww.insertIncome(c);
			System.out.println(ww.endYearCompanion());
			System.out.println();
			System.out.println(ww.endYearDrugs());
			System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IdAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CompanionDrugFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MissingUpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}