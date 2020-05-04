package sapient.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LockExample {

    public static void main(String[] args) {
        PrinterQueue printerQueue = new PrinterQueue();
        Executor executors = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executors.execute(new PrintingJob(printerQueue));
        }
    }
}


