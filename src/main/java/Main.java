import health_care_provider.errors.InvalidIdException;

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
        transformFactoryHashMap.put("labTests", new LabTestsTransformFactory(new LabValidateData()));
        writerFactoryHashMap.put("json", new JsonWriterFactory("C:\\Users\\REFAEL\\Desktop\\mada_repots\\report", new MadaReportConverter()));
        String[] names = new String[]{"IDNum", "IDType", "FirstName", "LastName", "ResultDate", "BirthDate", "LabCode", "StickerNumber", "ResultTestCorona", "Variant", "TestType", "JOIN_DATE", "HEALTH_CATE_ID", "HEALTH_CARE_NAME"};
        writerFactoryHashMap.put("xml", new XMLWriterFactory(new XMLConverter(names), "C:\\Users\\REFAEL\\Desktop\\LabTests\\report"));
        List<String[]> data = parserFactoryHashMap.get("csv2").parse();
        data = transformFactoryHashMap.get("labTests").transform(data);
        writerFactoryHashMap.get("xml").write(data);
    }
}
