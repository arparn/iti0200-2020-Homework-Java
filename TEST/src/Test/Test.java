package Test;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Test {

    public Integer secondsPassed = 0;
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed += 1;
            System.out.println(secondsPassed);

        }
    };
    public void timer() {
        myTimer.schedule(task, 10000);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.timer();
    }
}

