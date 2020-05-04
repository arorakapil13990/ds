package sapient.threading;

public class PrintingJob implements Runnable {

    private PrinterQueue printerQueue;

    public PrintingJob(PrinterQueue printerQueue) {
        this.printerQueue = printerQueue;
    }

    @Override
    public void run() {
        System.out.println("Going to print a document :: " + Thread.currentThread().getName());
        printerQueue.print();
    }
}
