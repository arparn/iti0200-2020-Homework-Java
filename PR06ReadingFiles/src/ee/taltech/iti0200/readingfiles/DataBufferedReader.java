package ee.taltech.iti0200.readingfiles;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataBufferedReader implements DataReader {
    private BufferedReader reader;
    public File fileToRead;
    List<String> linesReaded = new ArrayList<>();

    @Override
    public void setFileToRead(File file) {
        fileToRead = file;
    }

    @Override
    public List<String> readFile() {
        List<String> answer = new ArrayList<>();
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public Optional<String> readNextLine() {
        String line = "";
        try {
            boolean flag = false;
            reader = new BufferedReader(new FileReader(fileToRead));
            line = reader.readLine();
            while (!flag) {
                if (!linesReaded.contains(line) || line == null) {
                    linesReaded.add(line);
                    flag = true;
                    reader.close();
                } else {
                    line = reader.readLine();
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null || line.equals("")) {
            return Optional.empty();
        } else {
            return Optional.of(line);
        }
    }
}