package sapient.threading;

public class PrintSequenceRunnable implements Runnable {

    int remainder;
    static int number = 1;
    public int numbersUpto = 10;
    static Object lock = new Object();

    PrintSequenceRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < numbersUpto - 1) {
            synchronized (lock) {
                while (number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new PrintSequenceRunnable(1), "t1");
        Thread t2 = new Thread(new PrintSequenceRunnable(2), "t2");
        Thread t3 = new Thread(new PrintSequenceRunnable(0), "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
