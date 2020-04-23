package sapient.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {


    public void serialize(User user) throws IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("abc.ser"));
        out.writeObject(user);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        User u = new User("kapil", 29);
        new SerializationExample().serialize(u);
        System.out.println("Serialization complete");
    }
}
