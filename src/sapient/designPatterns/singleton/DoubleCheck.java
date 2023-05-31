package sapient.designPatterns.singleton;
// https://www.digitalocean.com/community/tutorials/thread-safety-in-java-singleton-classes

/*
https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/

* Please be sure to use “volatile” keyword with instance variable otherwise
*  you can run into an out of order write error scenario,
* where reference of an instance is returned before actually the object is constructed i.e.
* JVM has only allocated the memory and constructor code is still not executed.
* In this case, your other thread, which refers to the uninitialized object may throw
* null pointer exception
*  and can even crash the whole application.
* */

public class DoubleCheck {

    private static  volatile DoubleCheck obj ;

    private DoubleCheck(){
    }


    public static DoubleCheck getInstance(){
        if(obj == null){
            synchronized (DoubleCheck.class){
                if(obj == null){
                    obj = new DoubleCheck();
                }
            }
        }
        return obj;
    }

}
