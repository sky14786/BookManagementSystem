package application.kh.bms.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import application.kh.bms.model.User;

public class UserUpdateController {
	ArrayList<User> users = new ArrayList<User>();

	public void updateUser(String pw, String name, String Addr, String gender) {

	}

	public void loadUser() {

	}

	public void loadData() {

	}

//	public void loadData() {
//	try {
//		String fileName = "C:\\test\\user.xlsx";
//		FileInputStream fis = new FileInputStream(fileName);
//		HSSFWorkbook workbook = new HSSFWorkbook(fis);
//		HSSFSheet sheet = workbook.getSheetAt(0);
//		int rows = sheet.getPhysicalNumberOfRows();
//		for (int rowIndex = 1; rowIndex < rows; rowIndex++) {
//			HSSFRow row = sheet.getRow(rowIndex);
//			if (row != null) {
//				int cells = row.getPhysicalNumberOfCells();
//				for (int columnIndex = 0; columnIndex <= cells; columnIndex++) {
//					HSSFCell cell = row.getCell(columnIndex); // 셀에 담겨있는 값을 읽는다.
//					String value = "";
//					switch (cell.getCellType()) { // 각 셀에 담겨있는 데이터의 타입을 체크하고 해당 타입에 맞게 가져온다.
//					case HSSFCell.CELL_TYPE_NUMERIC:
//						value = cell.getNumericCellValue() + "";
//						break;
//					case HSSFCell.CELL_TYPE_STRING:
//						value = cell.getStringCellValue() + "";
//						break;
//					case HSSFCell.CellType.BLANK:
//						value = cell.getBooleanCellValue() + "";
//						break;
//					case HSSFCell.CELL_TYPE_ERROR:
//						value = cell.getErrorCellValue() + "";
//						break;
//					}
//					if (cell.getCellType() == cell.CellType.BLANK)
//						System.out.println(value);
//				}
//			}
//		}
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//
//}
}
