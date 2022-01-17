import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LineFileChecker implements FileChecker
{
    private final int MAX_LINES = 50000;
    @Override
    public boolean checkValid(String name) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(name));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines == MAX_LINES;
    }
}
