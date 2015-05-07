package com.app.sensitouch.sensor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PublishSensorData {

//	private Client client;
//	private WebTarget target;

	public static void main(String[] args) {	
		String policyKey = "Key";
		String policyDetails = "Policy"; 
		try {
			//boolean updateFlag = entitlementDataService.updateEntitlementPolicy(policyKey, policyDetails);				

			System.out.println("Publishing the sensor data: Start");

			//
			// An excel file name. You can create a file name with a full path
			// information.
			//
			String filename = "/Users/mahesh/Desktop/Project/FY13/MerlinArchitecture/EST/CuroEntitlement/load/EntitlementDetails_v14.xlsx";

			//
			// Create an ArrayList to store the data read from excel sheet.
			//
			List sheetData = new ArrayList();

			FileInputStream fis = null;
			try {
				//
				// Create a FileInputStream that will be use to read the excel file.
				//
				fis = new FileInputStream(filename);
				if (fis != null){
					//
					// Create an excel workbook from the file system.
					//
					XSSFWorkbook workbook = new XSSFWorkbook(fis);
					//
					// Get the first sheet on the workbook.
					//
					//XSSFSheet sheet = workbook.getSheetAt(0);
					XSSFSheet sheet = workbook.getSheet("Attribute Permissions");

					//
					// When we have a sheet object in hand we can iterator on each
					// sheet's rows and on each row's cells. We store the data read
					// on an ArrayList so that we can printed the content of the excel
					// to the console.
					//
					Iterator rows = sheet.rowIterator();
					int rowCount = 0;

					String cellC = null; String cellD = null; String cellE = null;
					String cellF = null; String cellG = null; String cellH = null;


					while (rows.hasNext()) {
						rowCount ++; 

						XSSFRow row = (XSSFRow) rows.next();
						//Iterator cells = row.cellIterator();

						List data = new ArrayList();
						//while (cells.hasNext()) {
						//XSSFCell cell = (XSSFCell) cells.next();
						short maxCols = row.getLastCellNum();
						if(maxCols > 12){
							String updateFlag = null;
							try{
								updateFlag = ((XSSFCell) row.getCell(12)).getRichStringCellValue().getString();
							}catch (Exception e){
								continue; 
							}

							String ncellC = ((XSSFCell) row.getCell(2)).getRichStringCellValue().getString();
							String ncellD = ((XSSFCell) row.getCell(3)).getRichStringCellValue().getString();
							String ncellE = ((XSSFCell) row.getCell(4)).getRichStringCellValue().getString();
							String ncellF = ((XSSFCell) row.getCell(5)).getRichStringCellValue().getString();
							String ncellG = ((XSSFCell) row.getCell(6)).getRichStringCellValue().getString();
							String ncellH = ((XSSFCell) row.getCell(7)).getRichStringCellValue().getString();

							// If all the cells are empty then ignore
							// also if update flag is null or not equal to 1 then ignore 
							if(StringUtils.isEmpty(ncellC) && StringUtils.isEmpty(ncellC)
									&& StringUtils.isEmpty(ncellC) && StringUtils.isEmpty(ncellC)
									&& StringUtils.isEmpty(ncellC) && StringUtils.isEmpty(ncellC)){
								continue; //i.e ignore
							}

							if(StringUtils.isNotEmpty(ncellC)){
								cellC = ncellC;
							}
							if(StringUtils.isNotEmpty(ncellD)){
								String[] str  = StringUtils.split(ncellD, ",");								
								cellD = str[0];

							}
							if(StringUtils.isNotEmpty(ncellE)){
								cellE = ncellE;
							}
							if(StringUtils.isNotEmpty(ncellF)){
								cellF = ncellF;
							}
							if(StringUtils.isNotEmpty(ncellG)){
								cellG = ncellG;
							}
							if(StringUtils.isNotEmpty(ncellH)){
								cellH = ncellH;
							}

							// if update flag is != Yes then ignore. 
							if(StringUtils.isEmpty(updateFlag) && ! StringUtils.equals(updateFlag,"Yes")){
								continue; //i.e ignore
							}

							StringBuilder policyKeySb =  new StringBuilder(); 
							policyKeySb.append(cellC).append(".")		        					
							.append(cellD).append(".")
							.append(cellE).append(".").append(cellF);

							if(! StringUtils.equals(ncellG, "ALL")){
								policyKeySb.append(".").append(cellG);
							}

							if(! StringUtils.equals(ncellH, "ALL")){
								policyKeySb.append(".").append(cellH);
							}

							policyKey = policyKeySb.toString();

							//System.out.println(policyKey);
							data.add(policyKey);
							policyDetails = ((XSSFCell) row.getCell(9)).getRichStringCellValue().getString();

							//Remove  attributePermissions and } from Policy String excel 
							if(StringUtils.isNotEmpty(policyDetails)){
								if(StringUtils.contains(policyDetails, " \"attributePermissions\": {")){
									policyDetails = StringUtils.replace(policyDetails, " \"attributePermissions\": {", "");
									policyDetails = StringUtils.stripEnd(policyDetails, "}");
								}
							}else{
								continue; 
							}

							data.add(policyDetails);							

							sheetData.add(data);
						}
						//	if(rowCount > 46){
						//		break;
						//	}							
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}  finally {
				if (fis != null) {
					fis.close();
				}
			}
			showListData(sheetData);
			//showExelData(sheetData);

			System.out.println("testUpdateEntitlementPolicy" + " Stop");
		}catch ( IOException e) {
			e.printStackTrace();
		}
		//			System.out.println("testUpdateEntitlementPolicy"
		//					+ new Gson().toJson(updateFlag));

	}


//	public void callPublishService{
//		client = ClientBuilder.newClient();
//		//query params: ?q=Turku&cnt=10&mode=json&units=metric
//		target = client.target("http://api.openweathermap.org/data/2.5/forecast/daily")
//				.queryParam("cnt", "10")
//				.queryParam("mode", "json")
//				.queryParam("units", "metric")
//				.queryParam("q", place)
//				.request(MediaType.APPLICATION_JSON)
//				.get(ForecastResponse.class);
//		
//		return target.queryParam("q", place)
//	            .request(MediaType.APPLICATION_JSON)
//	            .get(ForecastResponse.class);
//
//	}

	private static void showListData(List sheetData) {
		//
		// Iterates the data and print it out to the console.
		//
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				String cell = (String) list.get(j);
				System.out.print(cell);
				if (j < list.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}
	}



	private static void showExelData(List sheetData) {
		//
		// Iterates the data and print it out to the console.
		//
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				XSSFCell cell = (XSSFCell) list.get(j);
				System.out.print(cell.getRichStringCellValue().getString());
				if (j < list.size() - 1) {
					System.out.print(", ");
				}
			}
			System.out.println("");
		}
	}


}
