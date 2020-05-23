package sapient;

public class CallByReference {
    int id;


    public CallByReference(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;

    }

    public void changeReference(CallByReference obj) {
        obj = new CallByReference(10);
    }

    public void changeValue(CallByReference obj) {
        obj.setId(20);
    }

    public static void main(String[] args) {

        CallByReference obj = new CallByReference(5);
        System.out.println("Before changing reference :: " + obj.getId());

        obj.changeReference(obj);
        System.out.println("After changing reference :: " + obj.getId());

        obj.changeValue(obj);
        System.out.println("After changing value :: " + obj.getId());
    }
}
