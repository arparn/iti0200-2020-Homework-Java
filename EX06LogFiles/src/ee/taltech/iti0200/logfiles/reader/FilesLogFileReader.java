package ee.taltech.iti0200.logfiles.reader;
import ee.taltech.iti0200.logfiles.exception.LogFileReaderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FilesLogFileReader implements LogFileReader {

    private FileReader reader;

    @Override
    public String readLogs(String path) throws LogFileReaderException {
        File file = new File(path);
        StringBuilder answer = new StringBuilder();
        try {
            reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (!answer.toString().equals("")) {
                    answer.append("\n");
                }
                answer.append(line);
            }
            scanner.close();
            reader.close();
        } catch (FileNotFoundException e) {
            throw new LogFileReaderException("File not found");
        } catch (IOException e) {
            throw new LogFileReaderException("Unable to read file");
        }
        return answer.toString();
    }

    @Override
    public String readLogsWithLevel(String path, String level) throws LogFileReaderException {
        File file = new File(path);
        StringBuilder answer = new StringBuilder();
        try {
            reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.contains(level)) {
                    if (!answer.toString().equals("")) {
                        answer.append("\n");
                    }
                    answer.append(line);
                }
            }
            scanner.close();
            reader.close();
        } catch (FileNotFoundException e) {
            throw new LogFileReaderException("File not found");
        } catch (IOException e) {
            throw new LogFileReaderException("Unable to read file");
        }
        return answer.toString();
    }

    @Override
    public String readLogsBetween(String path, LocalDateTime from, LocalDateTime to) {
        File file = new File(path);
        StringBuilder answer = new StringBuilder();
        try {
            reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            String str;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.of(Integer.parseInt(str.substring(0, 4)),
                        Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)),
                        Integer.parseInt(str.substring(11, 13)), Integer.parseInt(str.substring(14, 16)),
                        Integer.parseInt(str.substring(17, 19)));
                if (dateTime.isAfter(from) && dateTime.isBefore(to)) {
                    if (!answer.toString().equals("")) {
                        answer.append("\n");
                    }
                    answer.append(str);
                }
            }
            scanner.close();
            reader.close();
        } catch (FileNotFoundException e) {
            throw new LogFileReaderException("File not found");
        } catch (IOException e) {
            throw new LogFileReaderException("Unable to read file");
        } catch (DateTimeParseException z) {
            throw new LogFileReaderException("Unable to parse date");
        }
        return answer.toString();
    }
}