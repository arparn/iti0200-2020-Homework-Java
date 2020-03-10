package ee.taltech.iti0200.logfiles.exception;

import ee.taltech.iti0200.logfiles.reader.LogFileReader;

public class LogFileReaderException extends RuntimeException  {
    String message;

    public LogFileReaderException(String sonum) {
        this.message = sonum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
