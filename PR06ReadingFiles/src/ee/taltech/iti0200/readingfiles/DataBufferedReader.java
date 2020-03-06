package ee.taltech.iti0200.readingfiles;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataBufferedReader implements DataReader {
    private BufferedReader reader;
    public File fileToRead;

    @Override
    public void setFileToRead(File file) {
        fileToRead = file;
    }

    @Override
    public List<String> readFile() throws IOException {
        List<String> answer = new ArrayList<>();
        reader = new BufferedReader(new FileReader(fileToRead));
        String line = reader.readLine();
        while (line != null) {
            if (line.equals("")) {
                continue;
            }
            answer.add(line);
            line = reader.readLine();
        }
        reader.close();
        return answer;
    }

    @Override
    public Optional<String> readNextLine() throws IOException {
        reader = new BufferedReader(new FileReader(fileToRead));
        String line = reader.readLine();
        if (line == null || line.equals("")) {
            return Optional.empty();
        } else {
            return Optional.of(line);
        }
    }
}