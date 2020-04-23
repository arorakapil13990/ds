package sapient.threading;

public class ThreadDemo implements Runnable {

    public synchronized void printNumber() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }

    public void printNumberSynchronisedBlock() {
        synchronized (this) {
            for (int i = 1; i < 10; i++) {
                System.out.println(i);
            }
        }
    }

    @Override
    public void run() {
        printNumber();
    }

    public static void main(String[] args) {
        ThreadDemo obj = new ThreadDemo();

        Thread t1 = new Thread(obj);
        t1.start();

        new Thread(()->{
            obj.printNumberSynchronisedBlock();
        }).start();
    }
}
