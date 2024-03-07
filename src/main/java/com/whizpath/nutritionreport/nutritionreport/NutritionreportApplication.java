package com.whizpath.nutritionreport.nutritionreport;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@SpringBootApplication
public class NutritionreportApplication {

	public static void main(String[] args) throws JRException{
		SpringApplication.run(NutritionreportApplication.class, args);
		String filePath = "C:\\CR-R\\Spring\\nutritionreport\\src\\main\\resources\\templates\\nutritionreport.jrxml";
		Map<String, Object> parametaters = new HashMap<>(); 
		parametaters.put("firstName", "John");
		parametaters.put("dob", "07/09/2020");
		parametaters.put("age", 20);
		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parametaters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print,"C:\\CR-R\\Spring\\nutritionreport\\src\\main\\resources\\static\\nutritionreport.pdf" );
		System.out.println("pdf 저장됨");
		
	}

}
