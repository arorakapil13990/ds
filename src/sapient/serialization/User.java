package sapient.serialization;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class User extends Human implements Serializable {
    private static final long serialVersionUID = 4L;

    private String name;
    private int age;
    private static volatile User user = null;

    private User() {
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private Object readResolve() {
        System.out.println("Read resolve is called");
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        User u = User.getInstance();
        User u1 = null;
        Constructor<?>[] constructors = User.class.getDeclaredConstructors();

        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            u1 = (User) constructor.newInstance();
        }
        System.out.println(u.hashCode() + " " + u1.hashCode());

    }
}
