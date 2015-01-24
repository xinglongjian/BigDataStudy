package com.xinglongjian.bigdata.web.customview;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
/**
 * for Pdf Test
 * @author root
 *
 */
public class TestPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		document.addTitle("My FIREST PDF!");         
		document.add(new Paragraph("Test date: " + new Date()));         
		
		Table orderDetails = new Table(4);         
		orderDetails.addCell("111");         
		orderDetails.addCell("222");         
		orderDetails.addCell("333");         
		orderDetails.addCell("444"); 
		
		for (int i=0;i<5;i++) {             
			orderDetails.addCell(i+"");             
			orderDetails.addCell(i*2+""); 
			orderDetails.addCell(i*3+""); 
			orderDetails.addCell(i*4+""); 
		}
		document.add(orderDetails); 
	}

}
