package linkedList;
//https://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
public class SortAbsoluteValue {

    Node head;
    // To sort a linked list by actual values.
    // The list is assumed to be sorted by absolute
    // values.
    private Node sort(Node head) {

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data < prev.data) {   // compare current = -2 and prev = 1
                prev.next = current.next;
                current.next = head;
                head = current;
                current = prev;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
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
        SortAbsoluteValue d = new SortAbsoluteValue();
        d.addToTail(1);
        d.addToTail(-2);
        d.addToTail(-3);
        d.addToTail(4);
        d.addToTail(-5);
        d.print(d.head);
        System.out.println();
        d.print(d.sort(d.head));
    }
}
