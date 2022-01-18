import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.sql.*;

public class SQLWriterFactory extends WriterFactory{

    private Connection conn;
    private String TableName;
    private String[] TableVariables; // since i am working i a general way when inserting to a table i have to verify variable to insert '' when string. I need the information

    @Override
    public void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException, SQLException {
        Statement stmt = this.conn.createStatement();
        for (String[] line: data)
        {
            String newLine = "INSERT INTO " + TableName + " VALUES (";
            for (int i = 0; i < this.TableVariables.length; i++)
            {
                if (this.TableVariables.equals("string"))
                {
                    newLine +=  "'" +  line[i] + "', ";
                }
                else if (this.TableVariables.equals("date"))
                {
                    Date date = java.sql.Date.valueOf(line[i]);
                    newLine +=  "'" +  date + "', ";
                }
                else
                {
                    newLine += line[i] + ", ";
                }
            }
            newLine = newLine.substring(0, newLine.length() - 2);
            newLine += ")";
            stmt.execute(newLine);
        }
    }

    public SQLWriterFactory(String filePath, String tableName, String[] tableHeadlines) {
        super(filePath);
        this.TableVariables = tableHeadlines;
        this.TableName = tableName;
        try
        {
            this.conn = DriverManager.getConnection(filePath);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
