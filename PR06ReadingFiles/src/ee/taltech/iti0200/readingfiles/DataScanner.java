package ee.taltech.iti0200.readingfiles;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class DataScanner implements DataReader {
    private Scanner scanner;

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
