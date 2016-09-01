package allbegray.sample.common.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Arrays;
import java.util.List;

public class AbstractSinglePageExcel extends AbstractExcel {

	protected Sheet sheet;
	protected int rownum;

	public AbstractSinglePageExcel() {
		super();
		this.sheet = workbook.createSheet();
	}
	
	public Row createRow() {
		return sheet.createRow(rownum++);
	}

	public Row addRow(String... columns) {
		return this.addRow(Arrays.asList(columns));
	}

	public Row addRow(List<String> columns) {
		Row row = this.createRow();
		int column = 0;
		for (String c : columns) {
			Cell cell = row.createCell(column++);
			cell.setCellValue(c);
		}
		return row;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
}
