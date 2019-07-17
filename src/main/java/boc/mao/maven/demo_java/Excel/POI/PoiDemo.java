/**
 * 
 */
package boc.mao.maven.demo_java.Excel.POI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author: 猪本聪
 * @description:  
 * @date: 2019年3月22日
 */


public class PoiDemo 
{
	//读取excel
    public static Workbook readExcel(String filePath)
    {
        Workbook wb = null;
        if(filePath==null)
        {
            return null;
        }
        
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try 
        {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString))
            {
                return wb = new HSSFWorkbook(is);
            }
            else if(".xlsx".equals(extString))
            {
                return wb = new XSSFWorkbook(is);
            }
            else
            {
                return wb = null;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

}
