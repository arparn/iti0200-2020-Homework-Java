package ee.taltech.iti0200.readingfiles;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DataReader {
    void setFileToRead(File file);

    List<String> readFile() throws IOException;

    Optional<String> readNextLine() throws IOException;
}
