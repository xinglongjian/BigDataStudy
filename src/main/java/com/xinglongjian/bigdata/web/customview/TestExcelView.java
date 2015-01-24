package com.xinglongjian.bigdata.web.customview;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
/**
 * For Excel Test
 * @author root
 *
 */
public class TestExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int sheetRowNum = 0;

		// 创建工作表和标题
		HSSFSheet sheet = workbook.createSheet("MyTestExcel");
		HSSFRow titleRow = sheet.createRow((short) sheetRowNum++);
		HSSFCell titleCell = titleRow.createCell((short) 0);
		titleCell.setCellValue("NumExcel");
		// 创建一个空行
		sheet.createRow(sheetRowNum++);
		// 创建数据表头
		String[] titles = { "111", "222" };
		HSSFRow dataTitleRow = sheet.createRow((short) sheetRowNum++);
		for (int i = 0; i < titles.length; i++) {
			HSSFCell cell = dataTitleRow.createCell((short) i);
			cell.setCellValue(titles[i]);
		}
		// 数据模型转换:创建表格数据
		for (int i = sheetRowNum; i < 5 + sheetRowNum; i++) {
				HSSFRow dataRow = sheet.createRow((short) (i));
				HSSFCell cell1 = dataRow.createCell((short) 0);
				HSSFCell cell2 = dataRow.createCell((short) 1);
				cell1.setCellValue(i);
				cell2.setCellValue(i*5);
		}
	}

}
