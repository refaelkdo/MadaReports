import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.sql.*;

public class SQLWriterFactory extends WriterFactory{

    private Connection conn;

    @Override
    public void write(List<String[]> data) throws IOException, InvocationTargetException, IllegalAccessException, SQLException {
        DatabaseMetaData dbm = this.conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "employee", null);
        if (tables.next()) {
            // Table exists
        }
        else {
            // Table does not exist
        }
    }

    public SQLWriterFactory(String filePath) {
        super(filePath);
        try
        {
            this.conn = DriverManager.getConnection(filePath);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
