package sample.future;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
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
        long threadId = LocalTime.now().getSecond();
        System.out.println(threadId + " started");

//        runStraight();
        runWithCompletableFuture();

        System.out.println(threadId + " finishing");
    }

    private void runWithCompletableFuture() {
        CompletableFuture
                .supplyAsync(() -> generateWrapped())
                .thenAccept(number -> writeWrapped(number));
    }

    private int generateWrapped() {
        try {
            return numberGenerator.generate();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeWrapped(int number) {
        try {
            numberWriter.writeNumber(number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void runStraight() {
        try {
            int number = numberGenerator.generate();
            numberWriter.writeNumber(number);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
