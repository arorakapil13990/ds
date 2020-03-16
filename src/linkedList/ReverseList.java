package linkedList;

public class ReverseList {

    Node head;

    public void reverseList(Node node) {
        Node prev = null;
        Node next;
        Node current = node;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ReverseList r = new ReverseList();
        r.head = new Node(1);
        r.head.next = new Node(2);
        r.head.next.next = new Node(3);
        r.head.next.next.next = new Node(4);

        r.reverseList(r.head);
        r.printList(r.head);

    }
}
