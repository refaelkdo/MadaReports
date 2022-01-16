import java.io.IOException;
import java.util.List;

public interface ParserFactory
{
    public List<String[]> parse() throws IOException;
}
