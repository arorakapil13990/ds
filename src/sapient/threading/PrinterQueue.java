package sapient.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrinterQueue {
    private final Lock lock = new ReentrantLock();

    public void print() {
        lock.lock();
        try {

            System.out.println("Printing job :: " + Thread.currentThread().getName());
        } finally {
            System.out.println("Lock released by :: " + Thread.currentThread().getName());
            lock.unlock();
        }
    }

}
