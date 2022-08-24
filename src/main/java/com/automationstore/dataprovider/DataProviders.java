package com.automationstore.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.automationstore.utility.ExcelUtility;

public class DataProviders {
	
	ExcelUtility objExcelUtility=new ExcelUtility();
	
	@DataProvider(name = "registerNewUserData")
	public Object[][] registerNewUserDetails(){
		
		int rows=objExcelUtility.getRowCount("registeNewUserSheet");
		int column=objExcelUtility.getColumnCount("registeNewUserSheet");
		
		Object[][] objData=new Object[rows-1][1];
		
		for (int i = 0; i < rows-1; i++) {
			Map<String, String> hashMap = new HashMap();
			for (int j = 0; j < column; j++) {
				hashMap.put(objExcelUtility.getCellData("registeNewUserSheet", j, 1),
						objExcelUtility.getCellData("registeNewUserSheet", j, i + 2));
			}
			objData[i][0]=hashMap;
		}
		return objData;
	}

	@DataProvider(name = "getProductDetails")
	public Object[][] getProductDetails(){
		
		int rows=objExcelUtility.getRowCount("productDetailsSheet");
		int column=objExcelUtility.getColumnCount("productDetailsSheet");
		
		Object[][] objData=new Object[rows-1][column];
		
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<column;j++) {
				objData[i][j]=objExcelUtility.getCellData("productDetailsSheet", j, i+2);
			}
		}
		return objData;
	}
}
