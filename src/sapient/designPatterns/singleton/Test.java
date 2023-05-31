package sapient.designPatterns.singleton;

public class Test {
    public static void main(String[] args) {
        EagerInitialisation ob1 =  EagerInitialisation.getInstance();
        EagerInitialisation ob2 =  EagerInitialisation.getInstance();

        System.out.println(ob1.hashCode() == ob2.hashCode());
    }


}
