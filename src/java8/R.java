package java8;

public interface R extends P {
    default void hello() {
        System.out.println("Hello from R");
    }
}
