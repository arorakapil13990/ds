package sapient;

public class Child extends Parent {

    public static void main(String[] args) {
        Parent p = new Child();
        p.printParent();
    }
}
