import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo{
    public static void main(String[] args) {

        List<Future<String>> list = new ArrayList<>();
        Executor ex = Executors.newCachedThreadPool();
        for(int i=1;i<=5;i++){
            list.add(((ExecutorService) ex).submit(new TaskWithResult(i)));
        }

        for(Future<String> f : list){
            try {
               System.out.println( f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                ((ExecutorService) ex).shutdown();
            }
        }
    }

}
