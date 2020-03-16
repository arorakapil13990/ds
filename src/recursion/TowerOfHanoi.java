package recursion;

public class TowerOfHanoi {


    public static void printTower(int n,char from, char to, char aux){

        if(n == 1){
            System.out.println("Move disk 1 from " + from + " to " + to ); // only 1 disk
            return;
        }

        /* Move n-1 disk from A -> B using C as auxiliary (helper) */
        printTower(n-1,from,aux,to);

        System.out.println("Move disk " + n + " from " + from + " to " + to);

        /* Move n-1 disk from B -> C using A as auxiliary (helper) */
        printTower(n-1,aux,to,from);
    }


    public static void main(String[] args) {

        printTower(3,'A','C','B');
    }
}
