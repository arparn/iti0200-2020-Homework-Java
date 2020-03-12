package ee.taltech.iti0200.logfiles;
import ee.taltech.iti0200.logfiles.reader.BufferedLogFileReader;
import ee.taltech.iti0200.logfiles.reader.FilesLogFileReader;
import ee.taltech.iti0200.logfiles.writer.LogFileWriter;
import java.time.LocalDateTime;

class LogFileController {

    private final BufferedLogFileReader bufferedLogFileReader = new BufferedLogFileReader();
    private final FilesLogFileReader filesLogFileReader = new FilesLogFileReader();
    private final LogFileWriter logFileWriter = new LogFileWriter();

    public static void main(String[] args) {
        LogFileController controller = new LogFileController();
        controller.logFileWriter.writeLogs("file.txt", "This gets saved in file.txt");
        System.out.println(controller.bufferedLogFileReader.readLogs("file.txt"));
        System.out.println(controller.filesLogFileReader.readLogs("file.txt"));

        controller.logFileWriter.writeLogs("log_file.txt",
                "2019-01-16 17:48:01.049 INFO 60674 --- [nio-8080-exec-1] com.Application : This is an info message"
        );

        System.out.println(controller.bufferedLogFileReader.readLogsWithLevel("log_file.txt", "INFO"));
        System.out.println(controller.filesLogFileReader.readLogsBetween("log_file.txt",
                LocalDateTime.MIN, LocalDateTime.MAX));
    }
}
