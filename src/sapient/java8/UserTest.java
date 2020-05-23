package sapient.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTest {

    public static void main(String[] args) {
        User u1 = new User("kapil1", 29,100);
        User u2 = new User("kapil2", 25,200);
        User u3 = new User("kapil3", 29,300);
        User u4 = new User("kapil4", 25,400);
        User u5 = new User("kapil5", 26,900);
        User u6 = new User("kapil6", 29,600);
        User u7 = new User("kapil7", 29,700);

        List<User> users = new ArrayList<>();

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        users.add(u7);

        System.out.println(users.stream().collect(Collectors.summingInt(User::getSalary)));
        System.out.println(users.stream().mapToInt(User::getSalary).sum());
    }
}
