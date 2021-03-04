package pattern.observer;

public class Test {
    public static void main(String[] args) {
        Observer one = new ObserverOne();
        Observer two = new ObserverTwo();
        Observer three = new ObserverThree();

        Message message = new Message("Hello");

        MessagePublisher messagePublisher = new MessagePublisher();
        messagePublisher.attach(one);
        messagePublisher.attach(two);

        messagePublisher.notify(message);

        System.out.println("Attaching third observer");
        messagePublisher.attach(three);
        System.out.println("Detaching Second observer");
        messagePublisher.detach(two);
        messagePublisher.notify(message);
    }
}
