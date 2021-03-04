package java8;

public interface Moveable {

    default void print(String str){
        System.out.println("Default :: " + str);
    }
}
