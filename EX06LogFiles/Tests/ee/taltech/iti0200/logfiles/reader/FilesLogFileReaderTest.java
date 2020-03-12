package ee.taltech.iti0200.logfiles.reader;

import ee.taltech.iti0200.logfiles.writer.LogFileWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilesLogFileReaderTest {

    FilesLogFileReader filesLogFileReader;
    LogFileWriter logFileWriter;

    @BeforeEach
    void setUp() {
        this.filesLogFileReader = new FilesLogFileReader();
        this.logFileWriter = new LogFileWriter();
    }

    @Test
    void readLogs() {
        logFileWriter.writeLogs("file.txt", "This gets saved in file.txt");
        String str = filesLogFileReader.readLogs("file.txt");
        assertEquals("This gets saved in file.txt", str);
    }

    @Test
    void readLogsWithLevel() {
        logFileWriter.writeLogs("log_file.txt",
                "2019-01-16 17:48:01.049 INFO 60674 --- " +
                        "[nio-8080-exec-1] com.Application : This is an info message"
        );
        String str = filesLogFileReader.readLogsWithLevel("log_file.txt", "INFO");
        assertEquals("2019-01-16 17:48:01.049 INFO 60674 --- [nio-8080-exec-1] com.Application : This is an info message", str);
    }

    @Test
    void readLogsBetween() {
        logFileWriter.writeLogs("log_file.txt",
                "2019-01-16 17:48:01.049 INFO 60674 --- " +
                        "[nio-8080-exec-1] com.Application : This is an info message"
        );
        String str = filesLogFileReader.readLogsWithLevel("log_file.txt", "INFO");
        assertEquals("2019-01-16 17:48:01.049 INFO 60674 --- [nio-8080-exec-1] com.Application : This is an info message", str);
    }
}
