package java8;

public interface P {
    default void hello() {
        System.out.println("Hello from P");
    }
}
