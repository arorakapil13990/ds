package sapient.threading;

public class TrafficLight implements Runnable {
    TrafficLight() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        while (true) {
            Thread turnRed = new Thread(new TurnRed());
            turnRed.start();
            synchronized (turnRed) {
                try {
                    turnRed.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread turnYellow = new Thread(new TurnYellow());
            turnYellow.start();
            synchronized (turnYellow) {
                try {
                    turnYellow.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread turnGreen = new Thread(new TurnGreen());
            turnGreen.start();
            synchronized (turnGreen) {
                try {
                    turnGreen.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }

    class TurnRed implements Runnable {
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("Red");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                notify();
            }
        }
    }

    class TurnYellow implements Runnable {
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("Yellow");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                notify();
            }
        }
    }

    class TurnGreen implements Runnable {
        public void run() {
            synchronized (this) {
                try {
                    System.out.println("Green");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                notify();
            }
        }
    }
}

