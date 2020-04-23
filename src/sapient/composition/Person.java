package sapient.composition;

public class Person {

    private final Job job;

    public Person() {
        this.job = new Job();
        job.setSalary(1000L);
    }

    public long getSalary() {
        return job.getSalary();
    }

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getSalary());
    }
}