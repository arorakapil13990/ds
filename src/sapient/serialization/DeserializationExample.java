package sapient.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {

    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.ser"));
        System.out.println(in.readObject());

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new DeserializationExample().deserialize();
    }
}
