/**
 * 
 */
package boc.mao.maven.demo_java.Excel.POI.junk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import boc.mao.maven.demo_java.Log4j.UseLog4j_2;

/**
 * @author: 猪本聪
 * @description:  POI操作Excel示例
 *                1、HSSFWorkBook：操作2003版本以前的（包括2003版本），扩展名.xls，该类在org.apache.poi:poi中
 *                2、XSSFWorkBook：操作2007版本以后的（包括2007版本），拓展名.xlsx，该类在org.apache.poi:poi-ooxml中
 *                3、SXSSFWorkBook：对于海量的数据进行操作
 *                
 * @date: 2019年1月24日
 */


public class POIDemo 
{
	private static Logger LOGGER = LogManager.getLogger(POIDemo.class);
	
	public POIDemo()
	{
		//读取使用Java的特性文件编写的配置文件
        PropertyConfigurator.configure( "src/log4j.properties" );
	}
	
	
	/*
	 * 读取 2003版本
	 * */
	public void readExcelHSSF(FileInputStream fileInputStream) throws IOException
	{
		//1.读取Excel的对象
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(fileInputStream);
        //2.Excel工作薄对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
        //3.Excel工作表对象
        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
        //总行数
        int rowLength = hssfSheet.getLastRowNum()+1;
        LOGGER.info("rowLength ==> " + rowLength);
        
	}
	
	
	/*
	 * 读取 2007版本
	 * */
	public void readExcelXSSF(FileInputStream fileInputStream) throws EncryptedDocumentException, IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		
		// 工作簿对象
        Sheet sheet = workbook.getSheetAt(0);
        
        // 总行数
        int rowLength = sheet.getLastRowNum()+1;
        LOGGER.info("总行数 rowLength ==> " + rowLength);
        
        // 工作表的列
        Row row = sheet.getRow(0);
        // 总列数
        int colLength = row.getLastCellNum();
        LOGGER.info("总列数 colLength ==> " + colLength);
        
        for (int i = 0; i < rowLength; i++) 
        {
            row = sheet.getRow(i);
            for (int j = 0; j < colLength; j++) 
            {
            	Cell cell = row.getCell(j);
            	
            	/*
            	 * Excel数据Cell有不同的类型，当我们试图从一个数字类型的Cell读取出一个字符串时就有可能报异常：
            	 * Cannot get a STRING value from a NUMERIC cell
            	 * 将所有的需要读的Cell表格设置为String格式
            	 * */
                if (cell != null)
                {
                	cell.setCellType(CellType.STRING);
                	LOGGER.info(cell.getStringCellValue() + "\t");
                } 
            }
        }
        
	}
	
	
	
	
	public static void main(String[] args)
	{
		try 
		{
			File file = new File("D:\\man.xlsx");
			FileInputStream fileInputStream = new FileInputStream(file);
			
			POIDemo poi = new POIDemo();
			poi.readExcelXSSF(fileInputStream);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
