package sapient.threading;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    Queue<Integer> stringQueue;

    public Consumer(Queue<Integer> stringQueue) {
        this.stringQueue = stringQueue;
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (stringQueue) {
                while (stringQueue.size() == 0) {
                    stringQueue.wait();
                }
                int val = stringQueue.poll();
                System.out.println("Consumer consumed - " + val);
                stringQueue.notify();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
