package sapient.threading;

import java.util.Queue;

public class Consumer implements Runnable {
    Queue<Integer> stringQueue;

    public Consumer(Queue<Integer> stringQueue) {
        this.stringQueue = stringQueue;
    }

    @Override
    public void run() {
        consume();
    }

    /*public void consume() throws InterruptedException {
        while (true) {
            synchronized (stringQueue) {
                while (stringQueue.isEmpty()) {
                    stringQueue.wait();
                }
                int val = stringQueue.poll();
                System.out.println("Consumer consumed - " + val);
                stringQueue.notify();
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }*/


    public void consume() {
        while (true) {
            synchronized (stringQueue) {
                if (stringQueue.isEmpty()) {
                    try {
                        System.out.println("Queue is Empty");
                        stringQueue.notify();
                        stringQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int val = stringQueue.poll();
                    System.out.println("Consumer consumed - " + val);
                }
            }
        }
    }
}
