package sample.future;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NumberWriter {

    private static final boolean append = true;

    public void writeNumber(int number) throws IOException {
        System.out.println("writing number");
        PrintWriter pw = new PrintWriter(new FileWriter("numbers.txt", append));
        pw.println(number);
        pw.close();
        System.out.println("number written");
    }
}
