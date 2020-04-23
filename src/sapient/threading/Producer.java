package sapient.threading;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {
    Queue<Integer> stringQueue;
    int val = 0;

    public Producer(Queue<Integer> stringQueue) {
        this.stringQueue = stringQueue;
    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (stringQueue) {
                while (stringQueue.size() == 5) {
                    stringQueue.wait();
                }
                System.out.println("Producer produced - " + val);
                stringQueue.add(val++);
                stringQueue.notify();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }
}
