import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HashMap<String, ParserFactory> parserFactoryHashMap = new HashMap<>();
        HashMap<String, WriterFactory> writerFactoryHashMap = new HashMap<>();
        parserFactoryHashMap.put("csv", new CsvParserFactory("C:\\Users\\REFAEL\\Desktop\\MadaReports\\src\\main\\resources\\MadaReports.csv"));
        Class thisclass = MadaObject.class;
        Method method = null;
        Method[] methods = thisclass.getDeclaredMethods();
        for(int i = 0; i < methods.length; i++)
        {
            if(methods[i].toString().equals("public MadaObject MadaObject.convertToClass(java.lang.String[])"))
                method = methods[i];
        }
        writerFactoryHashMap.put("json", new JsonWriterFactory("C:\\Users\\REFAEL\\Desktop\\mada_repots\\report", new MadaReportConverter()));
        List<String[]> data = parserFactoryHashMap.get("csv").parse();
        writerFactoryHashMap.get("json").write(data);
    }
}
