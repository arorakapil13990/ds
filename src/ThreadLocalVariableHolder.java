import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {

    private static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {

        Random r = new Random(55);

        @Override
        protected synchronized Integer initialValue() {
            return r.nextInt(1000);
        }
    };

    public static int get() {
        return local.get();
    }

    public static void increment() {
        local.set(local.get() + 1);
    }

    public static void main(String[] args) throws InterruptedException {

        Executor ex = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            ex.execute(new Acessor(i));
        }

        TimeUnit.SECONDS.sleep(2);
        ((ExecutorService) ex).shutdownNow();
    }


}

class Acessor implements Runnable {
    private int id;

    public Acessor(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Acessor{" +
                "id=" + id + " " + ThreadLocalVariableHolder.get() +
                '}';
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
}
