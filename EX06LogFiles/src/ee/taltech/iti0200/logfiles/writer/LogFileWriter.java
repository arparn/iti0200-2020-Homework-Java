package ee.taltech.iti0200.logfiles.writer;

import ee.taltech.iti0200.logfiles.exception.LogFileWriterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileWriter {

    /**
     * Write provided logs content to file.
     *
     * @param path    file saving path
     * @param content the content to write
     */
    public void writeLogs(String path, String content) throws LogFileWriterException {
        File file = new File(path);
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            throw new LogFileWriterException("Unable to write file");
        }
    }

    public static void main(String[] args) {
        LogFileWriter fileWriter = new LogFileWriter();
        fileWriter.writeLogs(System.getProperty("user.home") + "/Desktop" + "/file.txt", "zizn voram, hui musoram!!!!");
    }
}
