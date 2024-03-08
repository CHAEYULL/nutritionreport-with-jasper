package com.example.nation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.nation.model.enactRevisionData;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@SpringBootApplication
public class NationApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(NationApplication.class, args);
		String filePath = "/Users/fergus/Documents/CR-Project/Spring/nation/src/main/resources/templates/Blank04.jrxml";

		enactRevisionData content1 = new enactRevisionData(1, "content1", "me", "you","2020-01-01");
		enactRevisionData content2 = new enactRevisionData(1, "content11", "me", "you","2020-01-01");
		enactRevisionData content3 = new enactRevisionData(1, "content12", "me", "you","2020-01-01");
		enactRevisionData content4 = new enactRevisionData(1, "content13", "me", "you","2020-01-01");
		enactRevisionData content5 = new enactRevisionData(1, "content14", "me", "you","2020-01-01");
		enactRevisionData content6 = new enactRevisionData(1, "content15", "me", "you","2020-01-01");
		enactRevisionData content7 = new enactRevisionData(1, "content16", "me", "you","2020-01-01");
		enactRevisionData content8 = new enactRevisionData(1, "content17", "me", "you","2020-01-01");
		enactRevisionData content9 = new enactRevisionData(1, "content18", "me", "you","2020-01-01");
		enactRevisionData content10 = new enactRevisionData(1, "content19", "me", "you","2020-01-01");
		enactRevisionData content11 = new enactRevisionData(1, "content10", "me", "you","2020-01-01");
		enactRevisionData content12 = new enactRevisionData(1, "content121", "me", "you","2020-01-01");
		enactRevisionData content13 = new enactRevisionData(1, "content112", "me", "you","2020-01-01");
		enactRevisionData content14 = new enactRevisionData(1, "content123", "me", "you","2020-01-01");
		enactRevisionData content15 = new enactRevisionData(1, "content132", "me", "you","2020-01-01");
		enactRevisionData content16 = new enactRevisionData(1, "content1123", "me", "you","2020-01-01");
		
		List<enactRevisionData> enactRevisionList = new ArrayList<>();
		enactRevisionList.add(content1);
		enactRevisionList.add(content2);
		enactRevisionList.add(content3);
		enactRevisionList.add(content4);
		enactRevisionList.add(content5);
		enactRevisionList.add(content6);
		enactRevisionList.add(content7);
		enactRevisionList.add(content8);
		enactRevisionList.add(content9);
		enactRevisionList.add(content10);
		enactRevisionList.add(content11);
		enactRevisionList.add(content12);
		enactRevisionList.add(content13);
		enactRevisionList.add(content14);
		enactRevisionList.add(content15);
		enactRevisionList.add(content16);

		JRBeanCollectionDataSource revisiCollectionDataSource = new JRBeanCollectionDataSource(enactRevisionList);

		Map<String, Object> parameters = new HashMap<>();
		parameters.put("enactRevisionDataSet", revisiCollectionDataSource);
		
		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print,"/Users/fergus/Documents/CR-Project/Spring/nation/src/main/resources/static/Blank04.pdf");
		System.out.println("pdf저장됨");
		
	}

}
