import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class JsonWriterFactory extends WriterFactory
{
    private final int MAX_LINES = 50000;
    private Writer writer;
    private ConvertToClass method;
    private FileChecker fileChecker;

    @Override
    public void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException {
        int numLines = 0;
        int numFiles = 0;
        ObjectMapper objectMapper = new ObjectMapper();
        this.writer = new FileWriter(this.fileName + numFiles + ".json");
        for (String[] line:data) {
            if(this.fileChecker.checkValid(this.fileName + numFiles + ".json"))
            {
                this.writer.flush();
                numFiles++;
                this.writer = new FileWriter(this.fileName + numFiles + ".json");
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

    public JsonWriterFactory(String fileName, ConvertToClass method,FileChecker fileChecker) throws IOException {
        super(fileName);
        this.method = method;
        this.writer = new FileWriter(fileName);
        this.fileChecker = fileChecker;
    }
}
