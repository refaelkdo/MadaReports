import health_care_provider.errors.InvalidIdException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InvalidIdException {
        HashMap<String, ParserFactory> parserFactoryHashMap = new HashMap<>();
        HashMap<String, WriterFactory> writerFactoryHashMap = new HashMap<>();
        HashMap<String, TransformFactory> transformFactoryHashMap = new HashMap<>();
        parserFactoryHashMap.put("csv1", new CsvParserFactory("C:\\Users\\REFAEL\\Desktop\\MadaReports\\src\\main\\resources\\MadaReports.csv"));
        parserFactoryHashMap.put("csv2", new CsvParserFactory("C:\\Users\\REFAEL\\Desktop\\MadaReports\\src\\main\\resources\\LabTests.csv"));
        parserFactoryHashMap.put("csv3", new CsvParserFactory("C:\\Users\\REFAEL\\Desktop\\MadaReports\\src\\main\\resources\\Serology.csv"));
        List<String[]> data2 = parserFactoryHashMap.get("csv3").parse();
        parserFactoryHashMap.put("xlsx", new XLSXParserFactory("C:\\Users\\REFAEL\\Desktop\\MadaReports\\src\\main\\resources\\SerologicAntidots.xlsx"));
        transformFactoryHashMap.put("labTests", new LabTestsTransformFactory(new LabValidateData()));
        transformFactoryHashMap.put("labTests", new LabTestsTransformFactory(new LabValidateData()));
        writerFactoryHashMap.put("json", new JsonWriterFactory("C:\\Users\\REFAEL\\Desktop\\mada_repots\\report", new MadaReportConverter(),new LineFileChecker()));
        writerFactoryHashMap.put("json2", new JsonWriterFactory("C:\\Users\\REFAEL\\Desktop\\POSITIVE_CORONA_PEOPLE\\positive", new PositiveReportConverter(),new SizeFileChecker()));
        String[] names = new String[]{"IDNum", "IDType", "FirstName", "LastName", "ResultDate", "BirthDate", "LabCode", "StickerNumber", "ResultTestCorona", "Variant", "TestType", "JOIN_DATE", "HEALTH_CATE_ID", "HEALTH_CARE_NAME"};
        writerFactoryHashMap.put("xml", new XMLWriterFactory(new XMLConverter(names), "C:\\Users\\REFAEL\\Desktop\\LabTests\\report", new LineFileChecker()));
        List<String[]> data; parserFactoryHashMap.get("csv1").parse();
        //List<String[]> data2 = parserFactoryHashMap.get("csv2").parse();
        data = parserFactoryHashMap.get("xlsx").parse();
        transformFactoryHashMap.put("protect", new IsProtectedFactory(new serologyValidateDara(), data));
        data = transformFactoryHashMap.get("protect").transform(data2);
        for(String[] line: data)
        {
            for(int i = 0; i < line.length; i++)
            {
                System.out.print(line[i] + "-----");
            }
            System.out.println();
        }
        /*writerFactoryHashMap.get("json2").write(data);*/
    }
}
