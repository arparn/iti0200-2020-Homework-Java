package ee.taltech.iti0200.logfiles.exception;

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
