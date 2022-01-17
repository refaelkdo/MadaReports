import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class XMLWriterFactory implements WriterFactory{
    private final int MAX_LINES = 50000;
    private String fileName;
    private Writer writer;
    private ConvertToClass method;
    private FileChecker fileChecker;
    @Override
    public void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException {
        int numFiles = 0;
        int numLines = 0;
        for (String[] line:data) {
            if(numLines%MAX_LINES == 0)
            {
                this.writer.write("</labTests>");
                this.writer.flush();
                this.writer = new FileWriter(this.fileName + numFiles + ".xml");
                this.writer.write("<labTests>\n");
                numFiles++;
            }
            if(numLines != 0)
            {
                this.writer.write(String.valueOf(this.method.convert(line)));
            }
            numLines++;
        }
        this.writer.write("</labTests>");
        this.writer.flush();
    }

    public XMLWriterFactory(ConvertToClass method, String fileName, FileChecker fileChecker) throws IOException {
        this.method = method;
        this.fileName = fileName;
        this.writer = new FileWriter(this.fileName);
        this.fileChecker = fileChecker;
    }
}
