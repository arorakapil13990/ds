package pattern.observer;

public class ObserverThree implements Observer {
    @Override
    public void notifyUpdate(Message message) {
        System.out.println("Third Observer " + message.getMsg());
    }
}
