package linkedList;

public class CircularList {

    Node head;

    private void createList(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = n;
        }
        n.next = head;
    }

    private void insertAtFront(int data) {
        Node n = new Node(data);
        Node current = head;
        if (head != null) {
            while (current.next != head) {
                current = current.next;
            }
            n.next = head;
        }
        head = n;
        current.next = head;
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
        current.next = n;
        n.next = head;
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
        c.createList(1);
        c.createList(2);
        c.createList(3);
        c.createList(4);
        c.printList(c.head);
        c.insertAtFront(5);
        c.printList(c.head);

    }
}
