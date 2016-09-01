package allbegray.sample.common.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AbstractMultiplePageExcel extends AbstractExcel {

	protected List<SXSSFSheet> sheets = new ArrayList<>();

	public AbstractMultiplePageExcel() {
		super();
	}

	public Sheet createSheet() {
		return this.createSheet(null);
	}

	public Sheet createSheet(String sheetName) {
		SXSSFSheet sheet = StringUtils.hasText(sheetName) ? workbook.createSheet(sheetName) : workbook.createSheet();
		sheets.add(sheet);
		return sheet;
	}
	
	public Sheet getSheet(int page) {
		return sheets.get(page - 1);
	}

}
