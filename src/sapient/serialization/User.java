package sapient.serialization;

import java.io.Serializable;

public class User extends Human implements Serializable {
    private static final long serialVersionUID = 4L;

    private String name;
    private int age;

    public User(String name, int age) {
        System.out.println("User Constructor called");
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
