import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class JsonWriterFactory implements WriterFactory
{
    private final int MAX_LINES = 50000;
    private String fileName;
    private Writer writer;
    private ConvertToClass method;

    @Override
    public void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException {
        int numLines = 0;
        int numFiles = 0;
        MadaObject madaObject = new MadaObject();
        ObjectMapper objectMapper = new ObjectMapper();
        for (String[] line:data) {
            if(numLines%MAX_LINES == 0)
            {
                this.writer.flush();
                this.writer = new FileWriter(this.fileName + numFiles + ".json");
                numFiles++;
            }
            if(numLines != 0)
            {
                this.writer.write(objectMapper.writeValueAsString(this.method.convert(line)) + "\n");
            }
            numLines++;
        }
        this.writer.flush();
    }

    public String getFileName() {
        return fileName;
    }

    public JsonWriterFactory(String fileName, ConvertToClass method) throws IOException {
        this.fileName = fileName;
        this.method = method;
        this.writer = new FileWriter(fileName);
    }
}
