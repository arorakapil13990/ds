package gs;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

class CustomList<E> {

    private static int initialCapacity = 5;
    private Object[] element;
    private int size = 0;

    public CustomList() {
        element = new Object[initialCapacity];
    }


    private void ensureCapacity(int size) {
        if (size > initialCapacity) {
            initialCapacity = initialCapacity + (initialCapacity >> 1);
            element = Arrays.copyOf(element, initialCapacity);
        }
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        if (!isPresent(e)) {
            element[size++] = e;
        }
    }

    private boolean isPresent(E e) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(e)) {
                return true;
            }
        }
        return false;
    }


    public Object remove(int index) {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        Object removedElement = element[index];
        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];
        }
        size--;
        return removedElement;
    }


    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        return (E) element[index];
    }

    public int getSize() {
        return size;
    }

    public void display() {
        System.out.println("Size " + size);
        IntStream.range(0, size).mapToObj(a -> element[a]).forEach(System.out::println);
    }

    public CustomIterator iterator() {
        return new CustomIterator(this);
    }
}

class CustomIterator {
    private CustomList customList;
    private int position;

    public CustomIterator(CustomList customList) {
        this.customList = customList;
    }

    public boolean hasNext() {
        if (position < customList.getSize()) {
            return true;
        }
        return false;
    }

    public Object next() {
        Object aniObj = customList.get(position);
        position++;
        return aniObj;
    }

    public void remove() {
        customList.remove(position);
    }
}


class User {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        System.out.println(o);
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class CustomListDemo {

    public static void main(String[] args) {

        CustomList<User> cu = new CustomList<>();
        cu.add(new User("a", 1));
        cu.add(new User("b", 2));
        cu.add(new User("c", 3));
        cu.add(new User("d", 4));
        cu.add(new User("e", 5));
        cu.add(new User("f", 6));

        cu.display();

        cu.remove(1);
        cu.display();

        cu.add(new User("e", 5));
        cu.display();


        CustomIterator itr = cu.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}


