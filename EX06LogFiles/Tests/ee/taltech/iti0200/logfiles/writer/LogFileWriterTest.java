package ee.taltech.iti0200.logfiles.writer;

import ee.taltech.iti0200.logfiles.reader.BufferedLogFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LogFileWriterTest {

    BufferedLogFileReader bufferedLogFileReader;
    LogFileWriter logFileWriter;

    @BeforeEach
    void setUp() {
        this.bufferedLogFileReader = new BufferedLogFileReader();
        this.logFileWriter = new LogFileWriter();
    }

    @Test
    void writeLogs() {
        logFileWriter.writeLogs("file.txt", "This gets saved in file.txt");
        String str = bufferedLogFileReader.readLogs("file.txt");
        assertEquals("This gets saved in file.txt", str);
    }
}
