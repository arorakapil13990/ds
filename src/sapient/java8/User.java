package sapient.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class User {

    private String name;
    private int age;
    private int salary;


    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

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

        users.stream().sorted(Comparator.comparing(User::getSalary).reversed()).skip(1).limit(1).forEach(System.out::print);

        System.out.println("----");
        users.stream().collect(Collectors.groupingBy(User::getAge))
                .forEach((k, v) -> System.out.println((k + " " + v + " ")));

        System.out.println(users.stream().filter(e->e.getAge()>26).mapToInt(User::getSalary).sum());
        System.out.println(users.stream().filter(e->e.getAge()>26).collect(Collectors.summingInt(User::getSalary)));

    }
}
