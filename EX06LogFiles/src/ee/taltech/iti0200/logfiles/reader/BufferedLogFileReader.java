package ee.taltech.iti0200.logfiles.reader;
import ee.taltech.iti0200.logfiles.exception.LogFileReaderException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BufferedLogFileReader implements LogFileReader {

    private BufferedReader reader;

    @Override
    public String readLogs(String path) throws LogFileReaderException {
        File file = new File(path);
        StringBuilder answer = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!answer.toString().equals("")) {
                    answer.append("\n");
                }
                answer.append(str);
            }
            reader.close();
        }catch (FileNotFoundException x) {
            throw new LogFileReaderException("File not found");
        } catch (IOException e) {
            throw new LogFileReaderException("Unable to read file");
        }
        return answer.toString();
    }

    @Override
    public String readLogsWithLevel(String path, String level) {
        File file = new File(path);
        StringBuilder answer = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                if (str.contains(level)) {
                    if (!answer.toString().equals("")) {
                        answer.append("\n");
                    }
                    answer.append(str);
                }
            }
            reader.close();
        } catch (FileNotFoundException x) {
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
            reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                LocalDateTime dateTime = LocalDateTime.parse(str.substring(0, 10) + "T" + str.substring(11, 23));
                if (dateTime.isAfter(from) && dateTime.isBefore(to)) {
                    if (!answer.toString().equals("")) {
                        answer.append("\n");
                    }
                    answer.append(str);
                }
            }
            reader.close();
        } catch (FileNotFoundException x) {
            throw new LogFileReaderException("File not found");
        } catch (IOException e) {
            throw new LogFileReaderException("Unable to read file");
        } catch (DateTimeParseException z) {
            throw new LogFileReaderException("Unable to parse date");
        }
        return answer.toString();
    }
}
