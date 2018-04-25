package Utilities;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
 
public class ExcelApiTest extends GetRowCount{
 
    public ExcelApiTest(String xlFilePath) throws Exception
    {
        this.xlFilePath = xlFilePath;
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    }
}
