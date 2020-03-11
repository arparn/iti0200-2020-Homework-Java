package ee.taltech.iti0200.logfiles.reader;
import ee.taltech.iti0200.logfiles.exception.LogFileReaderException;

import java.time.LocalDateTime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class BufferedLogFileReader implements LogFileReader {

    private BufferedReader reader;

    @Override
    public String readLogs(String path) {
        File file = new File(path);
        StringBuilder answer = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                answer.append(str);
                answer.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                    answer.append(str);
                    answer.append("\n");
                }
            }
        } catch (LogFileReaderException | IOException e) {
            e.printStackTrace();
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
                StringBuilder dateStr = new StringBuilder();
                //if (Integer.parseInt(str.substring(18, 19)) < 5) {
                    //dateStr.append(str, 0, 18);
                //} else {
                    //int lastDigit = Integer.parseInt(str.substring(18, 19));
                    //lastDigit += 1;
                    //dateStr.append(str, 0, 17).append(lastDigit);
                //}
                LocalDateTime dateTime = LocalDateTime.of(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(5, 7)), Integer.parseInt(str.substring(8, 10)), Integer.parseInt(str.substring(11, 13)), Integer.parseInt(str.substring(14, 16)), Integer.parseInt(str.substring(17, 19)));
                if (dateTime.isAfter(from) && dateTime.isBefore(to)) {
                    answer.append(str);
                    answer.append("\n");
                }
            }
        } catch (LogFileReaderException | IOException e) {
            e.printStackTrace();
        }
        return answer.toString();
    }
}
