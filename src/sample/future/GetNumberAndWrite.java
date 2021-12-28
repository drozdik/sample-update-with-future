package sample.future;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class GetNumberAndWrite implements Runnable {

    private NumberGenerator numberGenerator;
    private NumberWriter numberWriter;

    public GetNumberAndWrite(NumberGenerator numberGenerator, NumberWriter numberWriter) {
        this.numberGenerator = numberGenerator;

        this.numberWriter = numberWriter;
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + " : staring at " + LocalTime.now().getSecond());
        try {
            System.out.println(threadId + " : generating number");
            int number = numberGenerator.generate();
            System.out.println(threadId + " : writing number " + number + " at " + LocalTime.now().getSecond());
            numberWriter.writeNumber(number);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
