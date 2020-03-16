import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread() + " " + this);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Executor ex = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i = 0;i<5;i++){
            ex.execute(new DaemonFromFactory());
        }
        try {

            TimeUnit.SECONDS.sleep(4);
            System.out.println("hi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
