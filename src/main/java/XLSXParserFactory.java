import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXParserFactory implements ParserFactory{

    private String filePath;

    public XLSXParserFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String[]> parse() throws IOException {
        List<String[]> data = new LinkedList<>();
        FileInputStream fis=new FileInputStream(new File(this.filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file
        while (itr.hasNext())
        {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
            ArrayList<String> line = new ArrayList<>();
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                        line.add(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                        line.add(String.valueOf(cell.getNumericCellValue()));
                        break;
                    default:
                }
            }
            data.add(line.toArray(String[]::new));
        }
        return data;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
