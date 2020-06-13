package gs;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Test<E> {

    private int initialCapacity = 5;
    private Object[] element;
    private int size;

    public Test() {
        element = new Object[initialCapacity];
    }


    private void ensureCapacity(int size) {
        if (size > initialCapacity) {
            initialCapacity = initialCapacity + (initialCapacity >> 1);
            element = Arrays.copyOf(element, initialCapacity);
        }
    }

    public void display() {
        IntStream.range(0, size).mapToObj(i -> element[i]).forEach(System.out::println);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        element[size++] = e;
    }


    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Try providing correct index");
        }
        return (E) element[index];
    }

    public void remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Try providing correct index");
        }

        for (int i = index; i < size ; i++) {
            element[i] = element[i + 1];
        }
        element[size] = null;
        size--;
    }

    public int getSize() {
        return size;
    }

    public TestIterator iterator() {
        return new TestIterator(this);
    }


    public static void main(String[] args) {
        Test<Integer> list = new Test<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);

        list.display();
        System.out.println(list.get(3));
        list.remove(5);
        System.out.println("------------------");
        list.display();

        System.out.println("------------------ " + list.getSize());

        TestIterator itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }

    }


    static class TestIterator {
        private Test test;
        private int pos;

        public TestIterator(Test test) {
            this.test = test;
        }

        public boolean hasNext() {
            if (pos >= test.getSize()) {
                return false;
            }
            return true;
        }

        public Object next() {
            if (pos > test.getSize()) {
                throw new IndexOutOfBoundsException();
            }
            Object e = test.get(pos);
            pos++;

            return e;
        }

        public void remove() {
            test.remove(pos);
        }

    }

 static  class User {
     String name;
     int id;

     public User(String name, int id) {
         this.name = name;
         this.id = id;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public boolean equals(Object o){
         if(this == o)return true;
         if(! (o instanceof User)) return false;
         User u = (User)o;
         return  (u.getId() == getId()) && Objects.equals(getName(), u.getName());
     }


     public int hasCode(){
         return Objects.hash(getId(),getName());
     }

 }


    }
