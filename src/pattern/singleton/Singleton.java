package pattern.singleton;

public class Singleton {
    private static volatile Singleton instance = null;
    private static Object object = new Object();

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (object){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton one = Singleton.getInstance();
        Singleton two = Singleton.getInstance();

        System.out.println(one.hashCode() == two.hashCode());
    }


}
