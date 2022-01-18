import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public abstract class WriterFactory
{
    protected String fileName;

    public WriterFactory(String filePath) {
        this.fileName = filePath;
    }

    public abstract void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException, SQLException;
}
