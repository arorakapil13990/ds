public class ThreadExample {

    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println("Hi from thread");
        };

        new Thread(task).start();


        new Thread(() -> System.out.println("hi")).start();

    }
}
