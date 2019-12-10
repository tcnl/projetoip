package rcs8tcnl.repository.weapon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import rcs8tcnl.basics.Weapon;
import rcs8tcnl.program.WarlordGUI;

public class WeaponRepositoryFile implements WeaponInterface, IteratorWeapon {
	private int index;
	private File file;
	private HSSFWorkbook workbook;
	private Sheet paper;
	private Sheet indexes;
	private int indexIterator;
	private Weapon[] arsenal;

	public WeaponRepositoryFile() throws IOException {
		this.file = new File(WarlordGUI.FILES_SPREADSHEET);
		FileInputStream entry = new FileInputStream(file);
		this.workbook = new HSSFWorkbook(entry);
		this.paper = workbook.getSheet(WarlordGUI.FILES_WEAPONS_SHEET);
		this.indexes = workbook.getSheet(WarlordGUI.FILES_INDEX_SHEET);
		index = this.getIndex();
		entry.close();
	}

	public WeaponRepositoryFile(Sheet sheet) {
		this.arsenal = new Weapon[index - 1];
		for (int i = 1; i < arsenal.length; i++) {
			Row row = sheet.getRow(i);
			if (row != null) {
				String serial = row.getCell(0).getStringCellValue();
				String name = row.getCell(1).getStringCellValue();
				int maxRounds = (int) row.getCell(2).getNumericCellValue();
				int bullets = (int) row.getCell(3).getNumericCellValue();
				arsenal[i] = new Weapon(serial, name, maxRounds, bullets);
			}
		}
		this.indexIterator = 0;
	}

	public boolean hasNext() {
		return indexIterator < arsenal.length;
	}

	public Weapon next() {
		return arsenal[indexIterator++];
	}

	public IteratorWeapon getIterator() {
		return new WeaponRepositoryFile(this.paper);
	}

	public void insert(Weapon gun) throws IOException {
		index = this.getIndex();
		Row row = paper.createRow(index);
		row.createCell(0).setCellValue(gun.getSerial());
		row.createCell(1).setCellValue(gun.getName());
		row.createCell(2).setCellValue(gun.getMaxRounds());
		row.createCell(3).setCellValue(gun.getBullets());
		this.setIndex(1);
		write();
	}

	public void update(String serial, Weapon gun) throws IOException {
		this.getIndex();
		for (int i = 1; i < index; i++) {
			Row row;
			if ((row = paper.getRow(i)) != null) {
				String cell = row.getCell(0).getStringCellValue();
				if (cell != null) {
					if (cell.equals(serial)) {
						double bullets = row.getCell(3).getNumericCellValue();
						row.getCell(3).setCellValue(gun.getBullets() + bullets);
						write();
					}
				}
			}
		}
	}

	public void remove(String serial) throws IOException {
		index = this.getIndex();
		Row row = this.searchRow(serial);
		paper.removeRow(row);
		paper.shiftRows(row.getRowNum() + 1, index, -1);
		this.setIndex(-1);
		write();
	}

	public Weapon search(String serial) {
		index = this.getIndex();
		Weapon aux = null;
		for (int i = 1; i < index && aux == null; i++) {
			Row row = paper.getRow(i);
			if (row != null) {
				String cell = row.getCell(0).getStringCellValue();
				if (cell.equals(serial)) {
					String serie = row.getCell(0).getStringCellValue();
					String name = row.getCell(1).getStringCellValue();
					int maxRounds = (int) row.getCell(2).getNumericCellValue();
					int bullets = (int) row.getCell(3).getNumericCellValue();
					aux = new Weapon(serial, name, maxRounds, bullets);
				}
			}
		}
		return aux;
	}

	public Row searchRow(String serial) {
		index = this.getIndex();
		Row row = null;
		for (int i = 1; (i < index) && (row == null); i++) {
			Row test;
			if ((test = paper.getRow(i + 1)) != null) {
				String cell = test.getCell(0).getStringCellValue();
				if (cell.equals(serial)) {
					row = test;
				}
			}
		}

		return row;
	}

	public void write() throws IOException {
		FileOutputStream exit = new FileOutputStream(file);
		workbook.write(exit);
		exit.close();
	}

	public void setIndex(int index) throws IOException {
		int x = (int) indexes.getRow(0).getCell(0).getNumericCellValue();
		indexes.getRow(0).getCell(0).setCellValue(x + index);
		write();
	}

	public int getIndex() {
		int ind = (int) indexes.getRow(0).getCell(0).getNumericCellValue();
		return ind;
	}
}
