public class Singleton {

    private static volatile Singleton instance = null;
    private static Object lock = new Object();

    private Singleton(){}

    public static Singleton getInstance(){

        if(instance == null){ // t1 t2

            synchronized (lock){

                if(instance == null){
                    instance= new Singleton();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {


    }
}
