package com.whizpath.nutritionreport.nutritionreport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.whizpath.nutritionreport.nutritionreport.model.Food;
import com.whizpath.nutritionreport.nutritionreport.model.MacroNutrient;
import com.whizpath.nutritionreport.nutritionreport.model.Nutrition;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@SpringBootApplication
public class NutritionreportApplication {

	public static void main(String[] args) throws JRException{
		SpringApplication.run(NutritionreportApplication.class, args);
		String filePath = "/Users/fergus/Documents/CR-Project/Spring/nutritionreport-with-jasper/src/main/resources/templates/nutritionreport.jrxml";

		Nutrition protein = new Nutrition("Protein", 62, 83, "g");
		Nutrition carbonhydrates = new Nutrition("Protein", 62, 83, "g");
		Nutrition fiber = new Nutrition("Protein", 62, 83, "g");
		Nutrition sugars = new Nutrition("Protein", 62, 83, "g");
		Nutrition fat = new Nutrition("Protein", 62, 83, "g");
		Nutrition cholesterol = new Nutrition("Protein", 62, 83, "g");
		Nutrition sodium = new Nutrition("Protein", 62, 83, "g");
		Nutrition potassium = new Nutrition("Protein", 62, 83, "g");
		Nutrition calcium = new Nutrition("Protein", 62, 83, "g");
		Nutrition iron = new Nutrition("Protein", 62, 83, "g");
		Nutrition apple = new Nutrition("Protein", 62, 83, "g");
		Nutrition banana = new Nutrition("Protein", 62, 83, "g");
		Nutrition melon = new Nutrition("Protein", 62, 83, "g");
		Nutrition watermelon = new Nutrition("Protein", 62, 83, "g");
		Nutrition peach = new Nutrition("Protein", 62, 83, "g");
		Nutrition grape = new Nutrition("Protein", 62, 83, "g");
		Nutrition milk = new Nutrition("Protein", 62, 83, "g");
		Nutrition chocomilk = new Nutrition("Protein", 62, 83, "g");
		Nutrition coffeemilk = new Nutrition("Protein", 62, 83, "g");
		Nutrition juice = new Nutrition("Protein", 62, 83, "g");
		
		List<Nutrition> nutritionList = new ArrayList<>();
		nutritionList.add(protein);
		nutritionList.add(carbonhydrates);
		nutritionList.add(fiber);
		nutritionList.add(sugars);
		nutritionList.add(fat);
		nutritionList.add(cholesterol);
		nutritionList.add(sodium);
		nutritionList.add(potassium);
		nutritionList.add(calcium);
		nutritionList.add(iron);
		nutritionList.add(apple);
		nutritionList.add(banana);
		nutritionList.add(melon);
		nutritionList.add(watermelon);
		nutritionList.add(peach);
		nutritionList.add(grape);
		nutritionList.add(milk);
		nutritionList.add(chocomilk);
		nutritionList.add(coffeemilk);
		nutritionList.add(juice);

		MacroNutrient carbMacroNutrient = new MacroNutrient("Crabohydrates", 48);
		MacroNutrient fatMacroNutrient = new MacroNutrient("Fat", 32);
		MacroNutrient proteinMacroNutrient = new MacroNutrient("Protein", 20);

		List<MacroNutrient> macroNutrientList = new ArrayList<>();
		macroNutrientList.add(carbMacroNutrient);
		macroNutrientList.add(fatMacroNutrient);
		macroNutrientList.add(proteinMacroNutrient);


		JRBeanCollectionDataSource macroNutrientDataSource = new JRBeanCollectionDataSource(macroNutrientList);
		JRBeanCollectionDataSource nutritionDataSource = new JRBeanCollectionDataSource(nutritionList);

		Map<String, Object> parametaters = new HashMap<>(); 
		parametaters.put("firstName", "John");
		parametaters.put("dob", "07/09/2020");
		parametaters.put("age", 20);
		parametaters.put("nutrtitionDataSet", nutritionDataSource);
		parametaters.put("macroNutrientDataSource", macroNutrientDataSource);
		parametaters.put("foodReport", getFoodReport() );
		parametaters.put("foodParameter", getFoodParameter());
		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parametaters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print,"/Users/fergus/Documents/CR-Project/Spring/nutritionreport-with-jasper/src/main/resources/static/nutritionreport.pdf" );
		System.out.println("pdf 저장됨");
		
	}

	private static JRBeanCollectionDataSource getFoodDataSource(){
		List<Food> foodList = new ArrayList<>();
		Food banana = new Food("banana", "breakfast",22,13,3);
		Food avocado = new Food("avocado", "brakfast",8,12,8);
		Food milk = new Food("milk","breakfast",8,12,8);
		Food chicken = new Food("chicken","lunch",2,0,26);
		Food rice = new Food("rice", "lunch", 0,25,26);
		Food egg = new Food("egg", "breakfast",5,0,6);
		Food potato = new Food("potato", "lunch",5,37,4);
		Food oats = new Food("oats","dinner",5,51,13);
		
		foodList.add(banana);
		foodList.add(avocado);
		foodList.add(milk);
		foodList.add(chicken);
		foodList.add(rice);
		foodList.add(egg);
		foodList.add(potato);
		foodList.add(oats);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(foodList);
		return dataSource;
	}

	private static Map getFoodParameter(){
		Map<String, Object> foodParameter = new HashMap<>();
		foodParameter.put("foodDataset", getFoodDataSource());
		return foodParameter;
	}

	private static JasperReport getFoodReport(){
		String filPath = "/Users/fergus/Documents/CR-Project/Spring/nutritionreport-with-jasper/src/main/resources/templates/food_nutrition.jrxml";
		JasperReport report = null;
		try {
			report = JasperCompileManager.compileReport(filPath);
		} catch (JRException e) {
			throw new RuntimeException(e);
		}
		return report;
	}


}


