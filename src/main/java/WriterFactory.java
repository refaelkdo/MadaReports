import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface WriterFactory
{
    public void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException;
}
