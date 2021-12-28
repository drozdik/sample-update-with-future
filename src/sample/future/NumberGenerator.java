package sample.future;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NumberGenerator {

    private final int min = 1;
    private final int max = 50;
    private Random rn;

    public NumberGenerator() {
        rn = new Random();
    }

    public int generate() throws InterruptedException {
        int result = (rn.nextInt((max - min + 1)) + min);
        TimeUnit.MILLISECONDS.sleep(100 * result);
        return result;
    }
}
