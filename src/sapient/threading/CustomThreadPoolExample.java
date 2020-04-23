package sapient.threading;

import java.time.LocalTime;

public class CustomThreadPoolExample {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());

            customThreadPool.execute(task);
        }
    }

    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void run() {
            System.out.println("Executing : " + name + ", Current Seconds : " + LocalTime.now().getSecond());
        }
    }
}