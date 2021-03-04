package linkedList;

public class CircularList {

    Node head, tail;

    public void createList(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        tail.next = head;
    }


    public void create(int data) {
        Node n = new Node(data);
        Node current = head;
        if (head == null) {
            head = n;
            n.next = head;
            return;
        }
        while (current.next != head) {
            current = current.next;
        }
        current.next=n;
        n.next=head;
    }

    public void printList(Node node) {

        Node current = node;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != node);
        System.out.println();
    }

    public void insertAtLast(int data) {
        Node n = new Node(data);
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = n;
        n.next = head;
    }

    public static void main(String[] args) {
        CircularList c = new CircularList();
        c.create(1);
        c.create(2);
        c.create(3);
        c.create(4);
        c.printList(c.head);
        c.insertAtLast(5);
        c.printList(c.head);

    }
}
