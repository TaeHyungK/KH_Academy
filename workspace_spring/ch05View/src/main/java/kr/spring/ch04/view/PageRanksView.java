package kr.spring.ch04.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import kr.spring.ch04.controller.PageRank;

public class PageRanksView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, 
				HttpServletRequest request, HttpServletResponse response) throws Exception {
		//sheet ����
		HSSFSheet sheet = createFirstSheet(workbook);
		
		//�÷����� ����
		createColumnLabel(sheet);
		
		//������ ó��
		List<PageRank> pageRanks = (List<PageRank>)model.get("pageRanks");
		int rowNum = 1;
		for(PageRank rank : pageRanks) {
			createPageRankRow(sheet, rank, rowNum++);
		}
		
		//response�� �̿��� �ٿ�ε尡 ����ǵ��� ��
		String fileName = "pageRanks2018.xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
	}
	
	//sheet ����
	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "������ ����");
		sheet.setColumnWidth(1, 265*20);
		
		return sheet;
	}
	
	//�÷�����
	private void createColumnLabel(HSSFSheet sheet) {
		HSSFRow firstRow = sheet.createRow(0); //ù��° ��
		HSSFCell cell = firstRow.createCell(0); //ù��° ��
		cell.setCellValue("����");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("������");
	}
	
	//�࿡ ������ ������ ó��
	private void createPageRankRow(HSSFSheet sheet, PageRank rank, int rowNum) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(rank.getRank());
		
		cell = row.createCell(1);
		cell.setCellValue(rank.getPage());
		
	}
}
