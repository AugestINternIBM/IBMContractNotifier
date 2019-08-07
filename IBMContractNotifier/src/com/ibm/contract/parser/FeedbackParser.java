package com.ibm.contract.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FeedbackParser {
	
	private FileInputStream fileInputStream;
	private Workbook workbook;
	private int numberOfSheets;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	
	private Iterator rowIterator;
	private Iterator cellIterator;
	
	private Map<String, Feedback> feedbackMap = new HashMap<String, Feedback>();
	
	private Map<String, Integer> columnsHeaderMap = new HashMap<String, Integer>();
	private int colNum;
	
	public Map getContractListFromExcel(String FILE_PATH) {

		try {
			System.out.println(FILE_PATH);
			this.fileInputStream = new FileInputStream(FILE_PATH);

			// Using XSSF for xlsx format, for xls use HSSF
			this.workbook = new XSSFWorkbook(fileInputStream);

			this.numberOfSheets = this.workbook.getNumberOfSheets();

			// looping over each workbook sheet
			for (int i = 0; i < this.numberOfSheets; i++) {
				this.sheet = this.workbook.getSheetAt(i);
				this.rowIterator = this.sheet.iterator();

				// Init header map
				this.initColumnsHeaderMap();

				// iterating over each row and start from the second one
				this.rowIterator.next();
				while (this.rowIterator.hasNext()) {

					this.row = (Row) this.rowIterator.next();

					// TODO : check count
					if (this.row.getCell(this.columnsHeaderMap.get("Project")) == null) {
						
					} else {
						if(this.feedbackMap.containsKey(this.row.getCell(this.columnsHeaderMap.get("Project")).toString())) {
							Feedback feedback = this.feedbackMap.get(this.row.getCell(this.columnsHeaderMap.get("Project")).toString());
							feedback.setNo_of_feedbacks(feedback.getNo_of_feedbacks() + 1);
							this.feedbackMap.put(this.row.getCell(this.columnsHeaderMap.get("Project")).toString(), feedback);
						}else {
							Feedback feedback = new Feedback();
							feedback.setNo_of_feedbacks(1);
							
							if(this.row.getCell(this.columnsHeaderMap.get("Project Name")) == null){
								feedback.setProject_name("");
							}else{
								feedback.setProject_name(this.row.getCell(this.columnsHeaderMap.get("Project Name")).toString());
							}
							
							if(this.row.getCell(this.columnsHeaderMap.get("Run Description")) == null){
								feedback.setProject_description("");
							}else{
								feedback.setProject_description(this.row.getCell(this.columnsHeaderMap.get("Run Description")).toString());
							}
							
							this.feedbackMap.put(this.row.getCell(this.columnsHeaderMap.get("Project")).toString(), feedback);
						}
					}
				}
			}

			this.fileInputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.feedbackMap;
	}

	private void initColumnsHeaderMap() {
		this.colNum = this.sheet.getRow(2).getLastCellNum();
		if (this.sheet.getRow(2).cellIterator().hasNext()) {
			for (int j = 0; j < this.colNum; j++) {
				this.columnsHeaderMap.put((this.sheet.getRow(2).getCell(j).toString()), j);
			}
		}
	}

}
