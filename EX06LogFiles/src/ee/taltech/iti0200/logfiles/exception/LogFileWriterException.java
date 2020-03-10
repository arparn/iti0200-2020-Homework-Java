package ee.taltech.iti0200.logfiles.exception;

import ee.taltech.iti0200.logfiles.writer.LogFileWriter;

public class LogFileWriterException extends RuntimeException  {
    String message;

    public LogFileWriterException(String sonum) {
        this.message = sonum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
