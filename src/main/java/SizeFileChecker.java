import java.io.File;
import java.io.IOException;

public class SizeFileChecker implements FileChecker{
    private final int CHANGE_COUNTING = 1024;//since i need to count in mb and 1kb=1024b and 1mb=1024kb.
    private final long MAX_SIZE = 20;//since i need to count in mb and 1kb=1024b and 1mb=1024kb.
    @Override
    public boolean checkValid(String name) throws IOException {
        File file = new File(name);
        long fileSizeInBytes = file.length();
        long fileSizeInKB = fileSizeInBytes / CHANGE_COUNTING;
        long fileSizeInMB = fileSizeInKB / CHANGE_COUNTING;
        return fileSizeInMB == MAX_SIZE;
    }
}
