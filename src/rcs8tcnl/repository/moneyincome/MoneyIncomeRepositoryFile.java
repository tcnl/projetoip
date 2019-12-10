package rcs8tcnl.repository.moneyincome;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import rcs8tcnl.basics.Drugs;
import rcs8tcnl.basics.MoneyIncome;
import rcs8tcnl.program.WarlordGUI;
import rcs8tcnl.basics.Companion;

public class MoneyIncomeRepositoryFile implements MoneyIncomeInterface, IteratorMoneyIncome {
	private int index;
	private File file;
	private HSSFWorkbook m;
	private Sheet paper;
	private Sheet indexes;
	private int indexIterator;
	private MoneyIncome[] money;

	public MoneyIncomeRepositoryFile() throws IOException {
		this.file = new File(WarlordGUI.FILES_SPREADSHEET);
		FileInputStream entry = new FileInputStream(file);
		this.m = new HSSFWorkbook(entry);
		this.paper = m.getSheet(WarlordGUI.FILES_MONEYINCOME_SHEET);
		this.indexes = m.getSheet(WarlordGUI.FILES_INDEX_SHEET);
		this.index = this.getIndex();
		entry.close();
	}

	private MoneyIncomeRepositoryFile(Sheet paper) {
		index = this.getIndex();
		this.money = new MoneyIncome[index - 1];
		for (int i = 1; i < money.length; i++) {
			Row row = paper.getRow(i);
			if (row != null) {
				String cell = row.getCell(0).getStringCellValue();
				if (cell.equals("Acompanhante")) {
					String iD = row.getCell(1).getStringCellValue();
					double money = row.getCell(2).getNumericCellValue();
					String name = row.getCell(3).getStringCellValue();
					int age = (int) row.getCell(4).getNumericCellValue();
					double foodCost = row.getCell(5).getNumericCellValue();
					int shiftHours = (int) row.getCell(6).getNumericCellValue();
					double shiftCost = row.getCell(7).getNumericCellValue();
					double lifetimeEarnings = row.getCell(8).getNumericCellValue();
					double drugsSold = row.getCell(9).getNumericCellValue();
					this.money[i] = new Companion(iD, name, age, foodCost, shiftHours, shiftCost);
					this.money[i].setMoney(money);
					((Companion) this.money[i]).setLifetimeEarnings(lifetimeEarnings);
					((Companion) this.money[i]).setDrugsSold(drugsSold);
				} else if (cell.equals("Droga")) {
					String iD = row.getCell(1).getStringCellValue();
					double money = row.getCell(2).getNumericCellValue();
					double weight = row.getCell(3).getNumericCellValue();
					double priceQuilo = row.getCell(4).getNumericCellValue();
					double lifetimeEarnings = row.getCell(5).getNumericCellValue();
					double G = row.getCell(6).getNumericCellValue();
					double BOS = row.getCell(7).getNumericCellValue();
					double CIT = row.getCell(8).getNumericCellValue();
					double RAI = row.getCell(9).getNumericCellValue();
					this.money[i] = new Drugs(iD, weight, priceQuilo);
					((Drugs) this.money[i]).setMoney(money);
					((Drugs) this.money[i]).setG(G);
					((Drugs) this.money[i]).setBOS(BOS);
					((Drugs) this.money[i]).setCIT(CIT);
					((Drugs) this.money[i]).setRaid(RAI);
					((Drugs) this.money[i]).setLifetimeEarnings(lifetimeEarnings);
				}
			}
		}
		this.indexIterator = 0;
	}

	public void insert(MoneyIncome type) throws IOException {
		index = this.getIndex();
		Row row = paper.createRow(index);
		row.createCell(1).setCellValue(type.getID());
		row.createCell(2).setCellValue(type.getMoney());
		if (type instanceof Drugs) {
			row.createCell(0).setCellValue("Droga");
			row.createCell(3).setCellValue(((Drugs) type).getWeight());
			row.createCell(4).setCellValue(((Drugs) type).getPriceQuilo());
			row.createCell(5).setCellValue(((Drugs) type).getLifetimeEarnings());
			row.createCell(6).setCellValue(((Drugs) type).getG());
			row.createCell(7).setCellValue(((Drugs) type).getBOS());
			row.createCell(8).setCellValue(((Drugs) type).getCIT());
			row.createCell(9).setCellValue(((Drugs) type).getRaid());
			write();
			this.setIndex(1);
		} else if (type instanceof Companion) {
			row.createCell(0).setCellValue("Acompanhante");
			row.createCell(3).setCellValue(((Companion) type).getName());
			row.createCell(4).setCellValue(((Companion) type).getAge());
			row.createCell(5).setCellValue(((Companion) type).getFoodCost());
			row.createCell(6).setCellValue(((Companion) type).getShiftHours());
			row.createCell(7).setCellValue(((Companion) type).getShiftCost());
			row.createCell(8).setCellValue(((Companion) type).getLifetimeEarnings());
			row.createCell(9).setCellValue(((Companion) type).getDrugsSold());
			write();
			this.setIndex(1);
		}
	}

	public void update(String iD, MoneyIncome type) throws IOException {
		index = this.getIndex();
		for (int i = 1; (i < index); i++) {
			Row row;
			if ((row = paper.getRow(i)) != null) {
				if (row.getCell(1).getStringCellValue().equalsIgnoreCase(iD)) {
					if (type instanceof Drugs) {
						row.getCell(2).setCellValue(((Drugs) type).getMoney());
						row.getCell(3).setCellValue(((Drugs) type).getWeight());
						row.getCell(5).setCellValue(((Drugs) type).getLifetimeEarnings());
						row.getCell(6).setCellValue(((Drugs) type).getG());
						row.getCell(7).setCellValue(((Drugs) type).getBOS());
						row.getCell(8).setCellValue(((Drugs) type).getCIT());
						row.getCell(9).setCellValue(((Drugs) type).getRaid());
						write();
					} else if (type instanceof Companion) {
						row.getCell(2).setCellValue(((Companion) type).getMoney());
						row.getCell(6).setCellValue(((Companion) type).getShiftHours());
						row.getCell(8).setCellValue(((Companion) type).getLifetimeEarnings());
						row.getCell(9).setCellValue(((Companion) type).getDrugsSold());
						write();
					}
				}
			}
		}
	}

	public void remove(String iD) throws IOException {
		index = this.getIndex();
		Row row = this.searchRow(iD);
		paper.removeRow(row);
		paper.shiftRows(row.getRowNum() + 1, index, -1);
		this.setIndex(-1);
		write();
	}

	public MoneyIncome search(String iD) {
		index = this.getIndex();
		MoneyIncome aux = null;
		for (int i = 1; i < index && aux == null; i++) {
			Row row = paper.getRow(i);
			if (row != null) {
				String ID = row.getCell(1).getStringCellValue();
				if (ID.equals(iD)) {
					String cell = row.getCell(0).getStringCellValue();
					if (cell.equals("Acompanhante")) {
						String id = row.getCell(1).getStringCellValue();
						double money = row.getCell(2).getNumericCellValue();
						String name = row.getCell(3).getStringCellValue();
						int age = (int) row.getCell(4).getNumericCellValue();
						double foodCost = row.getCell(5).getNumericCellValue();
						int shiftHours = (int) row.getCell(6).getNumericCellValue();
						double shiftCost = row.getCell(7).getNumericCellValue();
						double lifetimeEarnings = row.getCell(8).getNumericCellValue();
						double drugsSold = row.getCell(9).getNumericCellValue();
						aux = new Companion(id, name, age, foodCost, shiftHours, shiftCost);
						aux.setMoney(money);
						((Companion) aux).setLifetimeEarnings(lifetimeEarnings);
						((Companion) aux).setDrugsSold(drugsSold);
					} else if (cell.equals("Droga")) {
						String id = row.getCell(1).getStringCellValue();
						double money = row.getCell(2).getNumericCellValue();
						double weight = row.getCell(3).getNumericCellValue();
						double priceQuilo = row.getCell(4).getNumericCellValue();
						double lifetimeEarnings = row.getCell(5).getNumericCellValue();
						double G = row.getCell(6).getNumericCellValue();
						double BOS = row.getCell(7).getNumericCellValue();
						double CIT = row.getCell(8).getNumericCellValue();
						double RAI = row.getCell(9).getNumericCellValue();
						aux = new Drugs(id, weight, priceQuilo);
						((Drugs) aux).setMoney(money);
						((Drugs) aux).setG(G);
						((Drugs) aux).setBOS(BOS);
						((Drugs) aux).setCIT(CIT);
						((Drugs) aux).setRaid(RAI);
						((Drugs) aux).setLifetimeEarnings(lifetimeEarnings);
					}
				}
			}
		}
		return aux;
	}

	public Row searchRow(String dogTag) {
		index = this.getIndex();
		Row row = null;
		for (int i = 1; (i < index) && (row == null); i++) {
			Row test;
			if ((test = paper.getRow(i + 1)) != null) {
				if (test.getCell(0).getStringCellValue().equalsIgnoreCase(dogTag)) {
					row = test;
				}
			}
		}

		return row;
	}

	public void write() throws IOException {
		FileOutputStream exit = new FileOutputStream(file);
		m.write(exit);
		exit.close();
	}

	public boolean hasNext() {
		return indexIterator < money.length;
	}

	public MoneyIncome next() {
		return money[indexIterator++];
	}

	public IteratorMoneyIncome getIterator() {
		return new MoneyIncomeRepositoryFile(this.paper);
	}

	public void setIndex(int index) throws IOException {
		int x = (int) indexes.getRow(0).getCell(1).getNumericCellValue();
		indexes.getRow(0).getCell(1).setCellValue(x + index);
		write();
	}

	public int getIndex() {
		int ind = (int) indexes.getRow(0).getCell(1).getNumericCellValue();
		return ind;
	}
}