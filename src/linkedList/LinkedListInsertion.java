package linkedList;

public class LinkedListInsertion {

    Node head;


    public void insertNode(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }

    public void insertAtHead(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }

    }

    public void insertAtLast(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }


    public void insertAtPosition(int data, int pos) {
        Node n = new Node(data);
        if (pos == 1) {
            insertAtHead(data);
            return;
        }

        Node current = head;
        Node prev = head;
        int c = 1;
        while (c < pos && current.next != null) {
            c++;
            prev = current;
            current = current.next;
        }

        n.next=current;
        prev.next=n;
    }


    public void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedListInsertion l = new LinkedListInsertion();
        l.insertNode(1);
        l.insertNode(2);
        l.insertNode(3);
        l.insertNode(4);
        l.insertNode(5);

        l.printList(l.head);


        l.insertAtHead(10);
        l.printList(l.head);
        l.insertAtLast(11);
        l.printList(l.head);
        System.out.println("---------------");
        l.insertAtPosition(15,3);
        l.printList(l.head);


    }
}
