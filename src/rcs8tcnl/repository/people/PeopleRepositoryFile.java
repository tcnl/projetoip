package rcs8tcnl.repository.people;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import rcs8tcnl.basics.Army;
import rcs8tcnl.basics.People;
import rcs8tcnl.basics.Prisoner;
import rcs8tcnl.program.WarlordGUI;

public class PeopleRepositoryFile implements PeopleInterface, IteratorPeople {
	private int index;
	private File file;
	private HSSFWorkbook workbook;
	private Sheet paper;
	private Sheet indexes;
	private int indexIterator;
	private People[] people;

	public PeopleRepositoryFile() throws IOException {
		this.file = new File(WarlordGUI.FILES_SPREADSHEET);
		FileInputStream entry = new FileInputStream(file);
		this.workbook = new HSSFWorkbook(entry);
		this.paper = workbook.getSheet(WarlordGUI.FILES_PEOPLE_SHEET);
		this.indexes = workbook.getSheet(WarlordGUI.FILES_INDEX_SHEET);
		this.index = this.getIndex();
		entry.close();
	}

	private PeopleRepositoryFile(Sheet paper) {
		this.index = paper.getLastRowNum() + 1;
		this.people = new People[index - 1];

		for (int i = 1; i < people.length; i++) {
			Row row;
			if ((row = paper.getRow(i)) != null) {
				if (row.getCell(7).getStringCellValue()
						.equalsIgnoreCase("Soldado")) {
					String name = row.getCell(1).getStringCellValue();
					int age = (int) row.getCell(2).getNumericCellValue();
					double foodCost = row.getCell(4).getNumericCellValue();
					int workHours = (int) row.getCell(5).getNumericCellValue();
					String dogTag = row.getCell(0).getStringCellValue();
					boolean status = row.getCell(3).getBooleanCellValue();
					String gunName = row.getCell(6).getStringCellValue();
					people[i] = new Army(name, age, foodCost, workHours,
							dogTag, status, gunName);
				} else if (row.getCell(7).getStringCellValue()
						.equalsIgnoreCase("Prisioneiro")) {
					String name = row.getCell(1).getStringCellValue();
					int age = (int) row.getCell(2).getNumericCellValue();
					double foodCost = row.getCell(4).getNumericCellValue();
					int workHours = (int) row.getCell(5).getNumericCellValue();
					String dogTag = row.getCell(0).getStringCellValue();
					boolean status = row.getCell(3).getBooleanCellValue();
					double drugsCooked = row.getCell(6).getNumericCellValue();
					people[i] = new Prisoner(name, age, foodCost, workHours,
							dogTag, status);
					((Prisoner) people[i]).setDrugsCooked(drugsCooked);
				}
			}
		}
		this.indexIterator = 0;
	}

	public void insert(People people) throws IOException {
		Row row = paper.createRow(index);
		row.createCell(0).setCellValue(people.getDogtag());
		row.createCell(1).setCellValue(people.getName());
		row.createCell(2).setCellValue(people.getAge());
		row.createCell(3).setCellValue(people.getStatus());
		row.createCell(4).setCellValue(people.getFoodCost());
		row.createCell(5).setCellValue(people.getWorkHours());
		if (people instanceof Army) {
			row.createCell(6).setCellValue(((Army) people).getWeapon());
			row.createCell(7).setCellValue("Soldado");
			write();
			this.setIndex(1);
		} else if (people instanceof Prisoner) {
			row.createCell(6)
					.setCellValue(((Prisoner) people).getDrugsCooked());
			row.createCell(7).setCellValue("Prisioneiro");
			write();
			this.setIndex(1);
		}
	}

	public void update(String dogTag, People people) throws IOException {
		for (int i = 1; (i < index); i++) {
			Row row;
			if ((row = paper.getRow(i)) != null) {
				if (row.getCell(0).getStringCellValue()
						.equalsIgnoreCase(dogTag)) {
					if (people instanceof Army) {
						int workHours = (int) row.getCell(5)
								.getNumericCellValue();
						row.getCell(5).setCellValue(
								((Army) people).getWorkHours());
						row.getCell(3)
								.setCellValue(((Army) people).getStatus());
						write();
					} else if (people instanceof Prisoner) {
						int workHours = (int) row.getCell(5)
								.getNumericCellValue();
						double drugsCooked = row.getCell(6)
								.getNumericCellValue();
						row.getCell(5).setCellValue(
								((Prisoner) people).getWorkHours() + workHours);
						row.getCell(6).setCellValue(
								((Prisoner) people).getDrugsCooked()
										+ drugsCooked);
						row.getCell(3).setCellValue(
								((Prisoner) people).getStatus());
						write();
					}
				}
			}
		}

	}

	public void remove(String dogTag) throws IOException {
		index = this.getIndex();
		Row row = this.searchRow(dogTag);
		paper.shiftRows(row.getRowNum() + 1, index, -1);
		this.setIndex(-1);;
		write();
	}

	public People search(String dogTag) {
		index = this.getIndex();
		System.out.println(index);
		People aux = null;
		for (int i = 1; i < index && (aux == null); i++) {
			Row row = paper.getRow(i);
			if (row != null) {
				String dog = row.getCell(0).getStringCellValue();
				if (dog != null) {
					if (dog.equals(dogTag)) {
						String cell = row.getCell(7).getStringCellValue();
						if (cell != null) {
							if (cell.equals("Prisioneiro")) {
								String name = row.getCell(1)
										.getStringCellValue();
								int age = (int) row.getCell(2)
										.getNumericCellValue();
								double foodCost = row.getCell(4)
										.getNumericCellValue();
								int workHours = (int) row.getCell(5)
										.getNumericCellValue();
								String tag = row.getCell(0)
										.getStringCellValue();
								boolean status = row.getCell(3)
										.getBooleanCellValue();
								double drugsCooked = row.getCell(6)
										.getNumericCellValue();
								aux = new Prisoner(name, age, foodCost,
										workHours, tag, status);
								((Prisoner) aux).setDrugsCooked(drugsCooked);
							} else if (cell.equals("Soldado")) {
								String name = row.getCell(1)
										.getStringCellValue();
								int age = (int) row.getCell(2)
										.getNumericCellValue();
								double foodCost = row.getCell(4)
										.getNumericCellValue();
								int workHours = (int) row.getCell(5)
										.getNumericCellValue();
								String tag = row.getCell(0)
										.getStringCellValue();
								boolean status = row.getCell(3)
										.getBooleanCellValue();
								String gunName = row.getCell(6)
										.getStringCellValue();
								aux = new Army(name, age, foodCost, workHours,
										tag, status, gunName);
							}
						}
					}
				}
			}
		}
		return aux;
	}

	public void write() throws IOException {
		FileOutputStream exit = new FileOutputStream(file);
		workbook.write(exit);
		exit.close();
	}

	public Row searchRow(String dogTag) {
		index = this.getIndex();
		Row row = null;
		for (int i = 1; (i < index) && (row == null); i++) {
			Row test;
			if ((test = paper.getRow(i + 1)) != null) {
				if (test.getCell(0).getStringCellValue()
						.equalsIgnoreCase(dogTag)) {
					row = test;
				}
			}
		}

		return row;
	}

	public boolean hasNext() {
		return indexIterator < people.length;
	}

	public People next() {
		return people[indexIterator++];
	}

	public IteratorPeople getIterator() {
		return new PeopleRepositoryFile(this.paper);
	}
	
	public void setIndex(int index) throws IOException {
		int x = (int) indexes.getRow(0).getCell(2).getNumericCellValue();
		indexes.getRow(0).getCell(2).setCellValue(x + index);
		write();
	}

	public int getIndex() {
		this.index = (int) indexes.getRow(0).getCell(2).getNumericCellValue();
		return index;
	}

}