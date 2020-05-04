package sapient.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String name;
    private int age;


    public User(String name, int age) {
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

    public static void main(String[] args) {

        User u1 = new User("kapil1",29);
        User u2 = new User("kapil2",25);
        User u3 = new User("kapil3",29);
        User u4 = new User("kapil4",25);
        User u5 = new User("kapil5",26);
        User u6 = new User("kapil6",29);
        User u7 = new User("kapil7",29);

        List<User> users = new ArrayList<>();

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        users.add(u7);

        users.stream().collect(Collectors.groupingBy(User::getAge))
                .forEach((k,v) -> System.out.println((k + " " + v + " ")));

    }
}
