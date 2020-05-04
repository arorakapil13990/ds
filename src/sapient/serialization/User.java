package sapient.serialization;

import java.io.Serializable;

public class User extends Human implements Serializable {
    private static final long serialVersionUID = 4L;

    private String name;
    private int age;
    private static volatile User user=null;
    private  User() {
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

    private Object readResolve()  {
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
}
