package ee.taltech.iti0200.readingfiles;
import java.io.FileReader;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class DataFileReader implements DataReader {
    private FileReader reader;

    @Override
    public void setFileToRead(File file) {
    }

    @Override
    public List<String> readFile() {
        return null;
    }

    @Override
    public Optional<String> readNextLine() {
        return Optional.empty();
    }
}