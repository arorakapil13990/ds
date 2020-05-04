package sapient.threading;

import java.util.concurrent.TimeUnit;

public class ClassLocking {

    public synchronized static void printHello() {
        System.out.println("Hello");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized static void printHi() {
        System.out.println("Hi");
    }

    public static void main(String[] args) {
        new Thread(() -> {
            ClassLocking.printHello();
        }).start();

        new Thread(() -> {
            ClassLocking.printHi();
        }).start();
    }
}
