package java8;

// Pg.219 of java 8 in action...
public class C extends D implements B,A {
    public static void main(String[] args) {
        new C().hello();  // Hello from B..  again it will print 'Hello from B' on extending the class D

    }

    /*@Override
    public void hello(){
        A.super.hello();  // if we have removed tha extends from B interface.
    }*/
}
