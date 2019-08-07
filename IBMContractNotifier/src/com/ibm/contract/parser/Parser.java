package com.ibm.contract.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibm.www.rules.decisionservice.ContractRulesDeployment.ContractOperation.Contract;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Parser {

	private ArrayList<Contract> contractsList = new ArrayList<Contract>();
	private Contract contract;

	private FileInputStream fileInputStream;
	private Workbook workbook;
	private int numberOfSheets;
	private Sheet sheet;
	private Row row;
	private Cell cell;

	private Iterator rowIterator;
	private Iterator cellIterator;

	private Map<String, Integer> columnsHeaderMap = new HashMap<String, Integer>();
	private int colNum;
	
	private Map<String, Feedback> feedbackMap = new HashMap<String, Feedback>();

	public List getContractListFromExcel(String FILE_PATH , Map<String, Feedback> feedbackMap) {
		
		this.feedbackMap = feedbackMap;

		try {
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

					if(this.initContract()) {
						this.contractsList.add(this.contract);
					}
				}
			}

			this.fileInputStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.contractsList;
	}

	private void initColumnsHeaderMap() {
		this.colNum = this.sheet.getRow(0).getLastCellNum();
		if (this.sheet.getRow(0).cellIterator().hasNext()) {
			for (int j = 0; j < this.colNum; j++) {
				this.columnsHeaderMap.put((this.sheet.getRow(0).getCell(j).toString()), j);
			}
		}
	}

	private boolean initContract() {
		this.contract = new Contract();

		if (this.row.getCell(this.columnsHeaderMap.get("AccountID")) == null||
				this.row.getCell(this.columnsHeaderMap.get("AccountID")).toString().equals("")||
				this.row.getCell(this.columnsHeaderMap.get("AccountID")).toString().equals("TBD")||
				this.row.getCell(this.columnsHeaderMap.get("AccountID")).toString().equals("NULL")) {
			return false;
		} else {
			this.contract.setAccoundID(this.row.getCell(this.columnsHeaderMap.get("AccountID")).toString());
		}

		if (this.row.getCell(this.columnsHeaderMap.get("TCV")) == null||
				this.row.getCell(this.columnsHeaderMap.get("TCV")).toString().equals("")) {
			return false;
		} else {
			this.contract.setTcv(this.row.getCell(this.columnsHeaderMap.get("TCV")).getNumericCellValue());
		}
		
		// TODO : Bind pv columns
		Double[] pv = new Double[12];
		if (this.row.getCell(this.columnsHeaderMap.get("PV_01")) == null) {
			return false;
		} else {
			pv[0] = this.row.getCell(this.columnsHeaderMap.get("PV_01")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_02")) == null) {
			return false;
		} else {
			pv[1] = this.row.getCell(this.columnsHeaderMap.get("PV_02")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_03")) == null) {
			return false;
		} else {
			pv[2] = this.row.getCell(this.columnsHeaderMap.get("PV_03")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_04")) == null) {
			return false;
		} else {
			pv[3] = this.row.getCell(this.columnsHeaderMap.get("PV_04")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_05")) == null) {
			return false;
		} else {
			pv[4] = this.row.getCell(this.columnsHeaderMap.get("PV_05")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_06")) == null) {
			return false;
		} else {
			pv[5] = this.row.getCell(this.columnsHeaderMap.get("PV_06")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_07")) == null) {
			return false;
		} else {
			pv[6] = this.row.getCell(this.columnsHeaderMap.get("PV_07")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_08")) == null) {
			return false;
		} else {
			pv[7] = this.row.getCell(this.columnsHeaderMap.get("PV_08")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_09")) == null) {
			return false;
		} else {
			pv[8] = this.row.getCell(this.columnsHeaderMap.get("PV_09")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_10")) == null) {
			return false;
		} else {
			pv[9] = this.row.getCell(this.columnsHeaderMap.get("PV_10")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_11")) == null) {
			return false;
		} else {
			pv[10] = this.row.getCell(this.columnsHeaderMap.get("PV_11")).getNumericCellValue();
		}
		if (this.row.getCell(this.columnsHeaderMap.get("PV_12")) == null) {
			return false;
		} else {
			pv[11] = this.row.getCell(this.columnsHeaderMap.get("PV_12")).getNumericCellValue();
		}
		
		//this.contract.setPv(pv);
		
		if (this.row.getCell(this.columnsHeaderMap.get("Backlog")) == null||
				this.row.getCell(this.columnsHeaderMap.get("Backlog")).toString().equals("")) {
			return false;
		} else {
			this.contract.setBackLog(this.row.getCell(this.columnsHeaderMap.get("Backlog")).getNumericCellValue());
		}
		
		String[] candidates = this.contract.getAccoundID().split(",");
		int count = 0;

		for (String candidate : candidates) {
			if (feedbackMap.containsKey(candidate)) {
				count = count + this.feedbackMap.get(candidate).getNo_of_feedbacks();
				this.contract.setNumberOfFeedbacks(this.feedbackMap.get(candidate).getNo_of_feedbacks());
			}
		}
		
		this.contract.setNumberOfFeedbacks(count);

		int month = Calendar.getInstance().get(Calendar.MONTH);
		
		this.contract.setCurrentPv(pv[month-1]);
		
		
		/////////////////////////////////////////////////////////
		double year = (double)Calendar.getInstance().get(Calendar.YEAR);

		if (this.row.getCell(this.columnsHeaderMap.get("Yr")) != null &&this.row.getCell(this.columnsHeaderMap.get("Yr")).getNumericCellValue() != year||
				this.row.getCell(this.columnsHeaderMap.get("Yr")).toString().equals("")){
			return false;

		} 
		
		if(this.row.getCell(this.columnsHeaderMap.get("IMT")) != null &&!(this.row.getCell(this.columnsHeaderMap.get("IMT")).toString().equals("MEA"))||
				this.row.getCell(this.columnsHeaderMap.get("IMT")).toString().equals("")){
			return false;

		}
		
		if(this.row.getCell(this.columnsHeaderMap.get("Div Code")) != null &&!(this.row.getCell(this.columnsHeaderMap.get("Div Code")).toString().equals("7H")||
				this.row.getCell(this.columnsHeaderMap.get("Div Code")).toString().equals("K4")||
				this.row.getCell(this.columnsHeaderMap.get("Div Code")).toString().equals("7G")||
				this.row.getCell(this.columnsHeaderMap.get("Div Code")).toString().equals("8E"))||
				this.row.getCell(this.columnsHeaderMap.get("Div Code")).toString().equals("")){
			return false;

		}
		
		/*not checked*/
		//System.out.println();
		if(this.row.getCell(this.columnsHeaderMap.get("SignProbability")) != null && (!(this.row.getCell(this.columnsHeaderMap.get("SignProbability")).toString().equals("1.0"))||
				this.row.getCell(this.columnsHeaderMap.get("SignProbability")).toString().equals(""))){
			return false;

		}

		
		if(this.row.getCell(this.columnsHeaderMap.get("OppName")) != null && (this.row.getCell(this.columnsHeaderMap.get("OppName")).toString().contains("Sales Order")||
				this.row.getCell(this.columnsHeaderMap.get("OppName")).toString().equals(""))){
			return false;

		}
		
		if (this.row.getCell(this.columnsHeaderMap.get("Country")) == null||
				this.row.getCell(this.columnsHeaderMap.get("Country")).toString().equals("")) {
			return false;
		} else {
			this.contract.setCountry(this.row.getCell(this.columnsHeaderMap.get("Country")).toString());
		}
		/*
		if(this.feedbackMap.get(this.contract.getAccoundID()) != null){
			this.contract.setProjectName(this.feedbackMap.get(this.contract.getAccoundID()).getProject_name());
		
			this.contract.setProjectDescription(this.feedbackMap.get(this.contract.getAccoundID()).getProject_description());
		}
		else{
			this.contract.setProjectName("");
			
			this.contract.setProjectDescription("");
		
		}
		*/
		String CustomerName="";
		String oppName="";
		if (this.row.getCell(this.columnsHeaderMap.get("Customer Name")) != null) {
			CustomerName=this.row.getCell(this.columnsHeaderMap.get("Customer Name")).toString().replaceAll("\u001a", " ");
		} 
		if (this.row.getCell(this.columnsHeaderMap.get("OppName")) != null) {
			oppName=this.row.getCell(this.columnsHeaderMap.get("OppName")).toString().replaceAll("\u001a", " ");
		} 
		this.contract.setProjectName(CustomerName+ " "+oppName+ " ("+this.contract.getAccoundID()+")");
		
		return true;
	}
}
