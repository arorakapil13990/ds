import java.util.concurrent.Callable;

class TaskWithResult implements Callable {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "task with "+ id;
    }
}

