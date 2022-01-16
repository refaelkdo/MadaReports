import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException {
        HashMap<String, ParserFactory> parserFactoryHashMap = new HashMap<>();
        parserFactoryHashMap.put("csv", new CsvParserFactory("C:\\Users\\REFAEL\\Desktop\\MadaReports\\src\\main\\resources\\MadaReports.csv"));
        List<String[]> data = parserFactoryHashMap.get("csv").parse();
        for (String[] line:data) {
            for(int i = 0; i < line.length; i++)
            {
                System.out.print(line[i] + "---");
            }
            System.out.println();
        }
    }
}
