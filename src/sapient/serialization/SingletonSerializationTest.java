package sapient.serialization;

import java.io.*;

public class SingletonSerializationTest {
    public void serialize(User user) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("abc.ser"));
        out.writeObject(user);
        out.close();
    }

    public User deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("abc.ser"));
        return (User)in.readObject();

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonSerializationTest s = new SingletonSerializationTest();
        User u = User.getInstance();
        u.setAge(29);
        u.setName("kapil");
        s.serialize(u);

        System.out.println(u.hashCode() == s.deserialize().hashCode());  // false
    }
}
