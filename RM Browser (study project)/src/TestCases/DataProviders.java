package TestCases;

import org.testng.annotations.DataProvider;

import Utilities.ExcelApiTest;
import Utilities.ExcelBaseSetup;

public class DataProviders {

	String Login_Creadentials_file_path = "C:\\Users\\goleksova\\eclipse-workspace\\Login_Credentials.xlsx";
    String RMDEMO_Admin_user = "RMDEMO_Admin";
    ExcelApiTest eat = null;
    ExcelBaseSetup base;
	
    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(Login_Creadentials_file_path, RMDEMO_Admin_user);
        return data;
    }
 
    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);
 
        excelData = new Object[rows-1][columns];
 
        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }
 
        }
        return excelData;
    }  
	
}
