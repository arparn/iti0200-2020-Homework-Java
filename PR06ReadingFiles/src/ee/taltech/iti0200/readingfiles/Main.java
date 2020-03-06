package ee.taltech.iti0200.readingfiles;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static File createNewFile() {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("This is an example.\nThis is second line of file.");
            writer.close();
            return new File("example.txt");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void deleteFile(File file) {
        file.delete();
    }

    public static void main(String[] args) throws IOException {

        File file = createNewFile();

        //DataReader dataScanner = new DataScanner();
        //dataScanner.setFileToRead(file);
        //System.out.println(dataScanner.readFile());  // [This is an example., This is second line of file.]

        //deleteFile(file);

        //file = createNewFile();

        //DataReader dataBufferedReader = new DataBufferedReader();
        //dataBufferedReader.setFileToRead(file);
        //System.out.println(dataBufferedReader.readFile());  // [This is an example., This is second line of file.]

        //deleteFile(file);

        file = createNewFile();

        DataReader dataFileReader = new DataFileReader();
        dataFileReader.setFileToRead(file);
        System.out.println(dataFileReader.readFile());  // [This is an example., This is second line of file.]

        deleteFile(file);

    }
}