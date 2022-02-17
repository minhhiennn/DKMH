package code.webdkmh.utli.readFileExcel;

//reading value of a particular cell  
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PointReader {

    public Map<Integer, Double> StudentCount(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        Map<Integer, Double> map = new HashMap<Integer, Double>();
        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            Row row = itr.next();
            boolean check = false;
            for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
                Cell cell = row.getCell(c);
                if (cell != null && cell.getCellType() != CellType.BLANK)
                    check = true;
            }
            if (row.getRowNum() == 0 || check == false) {
                continue;
            } else {
                try {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    int studentID = (int) cellIterator.next().getNumericCellValue();
                    String firstName = cellIterator.next().getStringCellValue();
                    String lastName = cellIterator.next().getStringCellValue();
                    double finalResult = cellIterator.next().getNumericCellValue();
                    map.put(studentID, finalResult);
                    if (finalResult > 10 || finalResult < 0)
                        map.put(-row.getRowNum(), 1.0);
                } catch (Exception e) {
                    map.put(-row.getRowNum(), 0.0);
                }
            }
        }
        return map;

    }

}