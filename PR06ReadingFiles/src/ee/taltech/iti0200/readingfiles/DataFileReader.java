package ee.taltech.iti0200.readingfiles;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataFileReader implements DataReader {
    private FileReader reader;
    private File fileToRead;
    List<String> linesReaded = new ArrayList<>();

    @Override
    public void setFileToRead(File file) {
        fileToRead = file;
    }

    @Override
    public List<String> readFile() {
        List<String> answer = new ArrayList<>();
        try {
            reader = new FileReader(fileToRead);
            StringBuilder line = new StringBuilder();
            int i = reader.read();
            while (i > -1) {
                char newChar = (char) i;
                if (Character.toString(newChar).equals("\n")) {
                    i = reader.read();
                    if (!line.toString().equals("")) {
                        answer.add(line.toString());
                    }
                    line = new StringBuilder("");
                    continue;
                }
                line.append(newChar);
                i = reader.read();
            }
            if (!line.toString().equals("")) {
                answer.add(line.toString());
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public Optional<String> readNextLine() {
        StringBuilder line = new StringBuilder();
        try {
            reader = new FileReader(fileToRead);
            int i = reader.read();
            while (i > -1) {
                char newChar = (char) i;
                if (Character.toString(newChar).equals("\n") && !linesReaded.contains(line.toString())) {
                    linesReaded.add(line.toString());
                    break;
                } else if (Character.toString(newChar).equals("\n") && linesReaded.contains(line.toString())) {
                    i = reader.read();
                    line = new StringBuilder("");
                    continue;
                }
                line.append(newChar);
                i = reader.read();
            }
            if (i == -1 && linesReaded.contains(line.toString())) {
                return Optional.empty();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line.toString().equals("")) {
            return Optional.empty();
        } else {
            linesReaded.add(line.toString());
            return Optional.of(line.toString());
        }
    }
}
