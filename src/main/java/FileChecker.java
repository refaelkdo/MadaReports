import java.io.IOException;

public interface FileChecker //i am doing this with string and name for the case if i will have a table or a db.
{
    public boolean checkValid(String name) throws IOException;
}
