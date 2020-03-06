package ee.taltech.iti0200.readingfiles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.Optional;

public class DataScanner implements DataReader {
    private Scanner scanner;
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
            scanner = new Scanner(fileToRead);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.equals("")) {
                    continue;
                }
                answer.add(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public Optional<String> readNextLine() {
        String line = "";
        try {
            scanner = new Scanner(fileToRead);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (!linesReaded.contains(line)) {
                    break;
                }
            }
            if (!scanner.hasNextLine() && linesReaded.contains(line)) {
                return Optional.empty();
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line.equals("")) {
            linesReaded.add(line);
            return Optional.empty();
        } else {
            linesReaded.add(line);
            return Optional.of(line);
        }
    }
}
