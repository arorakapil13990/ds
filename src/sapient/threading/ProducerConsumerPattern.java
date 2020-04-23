package sapient.threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {

    public static void main(String args[]) {

        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        Thread prodThread = new Thread(new BlockingQProducer(sharedQueue));
        Thread consThread = new Thread(new BlockingQConsumer(sharedQueue));

        prodThread.start();
        consThread.start();
    }

}

class BlockingQProducer implements Runnable {

    private final BlockingQueue sharedQueue;

    public BlockingQProducer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

class BlockingQConsumer implements Runnable {

    private final BlockingQueue sharedQueue;

    public BlockingQConsumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + sharedQueue.take());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


}

