package datastructures;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyTimeSaverUtility {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			FileInputStream fis = new FileInputStream(new File("/Users/devpriya/Downloads/categoryIds.txt"));
//			BufferedReader bis = new BufferedReader(new InputStreamReader(fis));
//			List<String> list  = new ArrayList<>();
//			List<String> l = new ArrayList<String>();
//			list = bis.lines().collect(Collectors.toList());
//			//StringBuilder qry = new StringBuilder("select taxonomyid,categorypath from taxonomy where");
//			StringBuilder qry2 = new StringBuilder("select taxonomyid,categorypath from taxonomy where taxonomyid IN (");
//			int count=0;
//			while(!list.isEmpty()) {
//				qry2.append(list.get(0));
//				list.remove(0);
//				count++;
//				if(count==1000 || list.isEmpty()) {
//					qry2.append(") and inactivetimestamp is null");
//					if(!list.isEmpty()) {
//						qry2.append(" OR  taxonomyid IN (");
//					}
//					count = 0;
//				} else {
//					qry2.append(",");
//				}
//			}
//			System.out.println(qry2.toString());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//	}

	public static void main(String[] args)   
	{  
	try  
	{  
	//File file = new File("/Users/devpriya/Downloads/BuyerExchangeReports/ConsolidatedReportCopy2.xlsx");   //creating a new file instance
	FileInputStream fis = new FileInputStream(new File("/Users/devpriya/Downloads/BuyerExchangeReports/ConsolidatedReportCopy.xlsx"));
	System.out.println("here");
	//FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
	//creating Workbook instance that refers to .xlsx file  
	XSSFWorkbook wb = new XSSFWorkbook(fis);   System.out.println("here");
	XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
	Iterator<Row> itr = sheet.iterator();    //iterating over excel file
	System.out.println("here1");
	while (itr.hasNext())                 
	{  
	Row row = itr.next();  
	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
	while (cellIterator.hasNext())   
	{  
	Cell cell = cellIterator.next();  
	System.out.println(cell.getCellTypeEnum());
	switch (cell.getCellType())               
	{  
	case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
	System.out.print(cell.getStringCellValue() + "\t\t\t");  
	break;  
	case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
	System.out.print(cell.getNumericCellValue() + "\t\t\t");  
	break;  
	default:  
	}  
	}  
	System.out.println("");  
	}  
	}  
	catch(Exception e)  
	{  
		e.printStackTrace();
	}  
	}
	
	
}
