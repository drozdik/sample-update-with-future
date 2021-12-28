package sample.future;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // application assemble
        NumberWriter numberWriter = new NumberWriter();
        NumberGenerator numberGenerator = new NumberGenerator();
        //

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new GetNumberAndWrite(numberGenerator, numberWriter), 6, 6, TimeUnit.SECONDS);

/*        for (int i = 0; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("asking for number");
            int number = numberGenerator.generate();
            System.out.println("writing number " + number);
            numberWriter.writeNumber(number);
        }*/
    }

    /*
    * periodically ask generator for new number when number is get then write it into file
    *
    * */
}
