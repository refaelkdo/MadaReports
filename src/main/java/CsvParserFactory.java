import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CsvParserFactory implements ParserFactory
{

    private String filePath;

    @Override
    public List<String[]> parse() throws IOException {
        List<String[]> data = new LinkedList<>();
        int i = 0;
        ArrayList<String> line = new ArrayList<>();
        CSVParser records = CSVParser.parse(new File(filePath),
                Charset.forName("utf-8"),
                CSVFormat.DEFAULT);
        for(CSVRecord record:records)
        {
            line = new ArrayList<>();
            try {

                while (record.get(i) != null) {
                    line.add(record.get(i));
                    i++;
                }
            }
            catch (Exception e)
            {

            }
            data.add(line.toArray(String[]::new));
            i = 0;
        }
        return data;
    }

    public CsvParserFactory(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


}
