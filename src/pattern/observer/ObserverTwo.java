package pattern.observer;

public class ObserverTwo implements Observer {
    @Override
    public void notifyUpdate(Message message) {
        System.out.println("Second Observer " + message.getMsg());
    }
}
