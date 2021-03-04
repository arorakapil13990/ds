package pattern.observer;

import java.util.ArrayList;
import java.util.List;

// Observable
public class MessagePublisher implements Subject {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(Message message) {
        observers.stream().forEach(o -> o.notifyUpdate(message));
    }
}
