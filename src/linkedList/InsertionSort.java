package linkedList;

public class InsertionSort {

    Node head, sorted;

    public void insertion(Node node) {
        sorted = null;
        Node current = node;
        while (current != null) {
            Node next = current.next;
            sortedInsert(current);
            current = next;
        }
        head = sorted;
    }

    public void sortedInsert(Node newNode) {

        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }


    public void addToTail(int data) {

        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        InsertionSort d = new InsertionSort();
        d.addToTail(30);
        d.addToTail(3);
        d.addToTail(4);
        d.addToTail(20);
        d.addToTail(5);
       /* d.addToTail(1);
        d.addToTail(-10);*/


        d.insertion(d.head);
        d.print(d.head);
    }
}
