package sapient.designPatterns.singleton;
// https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples
/*
* In eager initialization, the instance of the singleton class is created at the time of class loading.
* The drawback to eager initialization is that the method is created even though
* the client application might not be using it.
* f your singleton class is not using a lot of resources,
* this is the approach to use. But in most of the scenarios,
* singleton classes are created for resources such as File System,
* Database connections, etc.
* We should avoid the instantiation unless the client calls the getInstance method.
* Also, this method doesn’t provide any options for exception handling.
 * */
public class EagerInitialisation {

    private static final EagerInitialisation object = new EagerInitialisation();

    private EagerInitialisation() {
    }
    public static EagerInitialisation getInstance(){
        return object;
    }

}


