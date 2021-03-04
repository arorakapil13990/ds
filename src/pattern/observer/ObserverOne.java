package pattern.observer;

public class ObserverOne implements Observer {
    @Override
    public void notifyUpdate(Message message) {
        System.out.println("First Observer " + message.getMsg());
    }
}
