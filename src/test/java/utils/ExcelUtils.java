package utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    static File file = new File(ConfigReader.get("excelfilepath"));
    static FileInputStream fis;

    /*static {
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

    static Workbook  workbook;

    /*static {
        try {
            workbook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    static Sheet sheet ;
    public static void writeData(String name , String partNo, String serialNo){


        try{


            //check if exists
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheet("Voter Details");
                // If sheet not present → create
                if (sheet == null) {
                    sheet = workbook.createSheet("Voter Details");
                }
            }
            else{
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Voter Details");
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Voter ID");
                header.createCell(1).setCellValue("Name");
                header.createCell(2).setCellValue("Part No");
               // header.createCell(4).setCellValue("Part No");
                header.createCell(3).setCellValue("Serial No");
            }
            int lastRow = sheet.getLastRowNum();
            Row rowlast = sheet.getRow(lastRow);
            int lastCellNum =rowlast.getLastCellNum();
            Cell cellLast = rowlast.getCell(lastCellNum, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String valLastCell = cellLast.getStringCellValue();
            if(valLastCell==""){
                lastRow = lastRow-1;
            }

            int newRowNum = (lastRow ==0 && sheet.getRow(0)!=null) ? 1: lastRow+1;
            //Row row = sheet.createRow(newRowNum);

            rowlast.createCell(1).setCellValue(name);
            rowlast.createCell(2).setCellValue(partNo);
            rowlast.createCell(3).setCellValue(serialNo);

            //write back to file
            FileOutputStream fos = new FileOutputStream(ConfigReader.get("excelfilepath"));
            workbook.write(fos);
            fos.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
       /*XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.*/
    }
    //check
    public static String getData(String columnName) throws IOException {
        String  text= null;
        try {
            InputStream fi = ExcelUtils.class
                    .getClassLoader()
                    .getResourceAsStream("voterData.xlsx");

            if (fi == null) {
                throw new RuntimeException("voterData.xlsx not found");
            }
            workbook = new XSSFWorkbook(fi);
            Sheet sheet = workbook.getSheet("Voter Details");
            Row getRow = sheet.getRow(sheet.getLastRowNum());
            Row headerRow   = sheet.getRow(0);
            int columnIndex = -1;
            for(int i = 0 ; i<headerRow.getLastCellNum();i++){
                String value = headerRow.getCell(i).getStringCellValue();
                if(value.equalsIgnoreCase(columnName)){
                    columnIndex = i;
                    break;
                }
            }
            Cell cell = getRow.getCell(columnIndex);
            text = cell.getStringCellValue();


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return text;
    }
}
