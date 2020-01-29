package Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public int loop() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return 0;
    }
    public static void main(String[] args) {
        Test introduction = new Test();
        introduction.loop();
    }
}
