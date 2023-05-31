package gs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {


    static class Employee implements Comparable<Employee> {

        Integer id;
        String name;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public int compareTo(Employee o) {
            return this.getId().compareTo(o.getId());
        }


        public String toString() {
            return "Employee = [ id = "+ id + " , Name = "+ name +" ]";
        }
    }


    public static void main(String[] args) {

        /*PriorityQueue<Employee> queue = new PriorityQueue<>();
        queue.add(new Employee(5, "a"));
        queue.add(new Employee(3, "b"));
        queue.add(new Employee(2, "c"));
        queue.add(new Employee(4, "d"));
        queue.add(new Employee(1, "e"));

        //System.out.println(queue.poll());

        while (true){
            Employee e = queue.poll();
            if(e == null)
                break;

            System.out.println(e);
        }*/
        Comparator comparator = Comparator.comparing(Employee::getName);
        PriorityQueue<Employee> queue = new PriorityQueue<>(comparator);
        queue.add(new Employee(5, "q"));
        queue.add(new Employee(3, "a"));
        queue.add(new Employee(2, "f"));
        queue.add(new Employee(4, "z"));
        queue.add(new Employee(1, "e"));

        //System.out.println(queue.poll());

        while (true){
            Employee e = queue.poll();
            if(e == null)
                break;

            System.out.println(e);
        }
    }
}
