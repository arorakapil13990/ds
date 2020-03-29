package linkedList;

public class ReverseNodeInGroup {
    Node head;


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseNodeInGroup s = new ReverseNodeInGroup();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);

        s.printList(s.printReverseRecursive(s.head, 2));
    }


    private Node printReverseRecursive(Node head, int i) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count < i && current != null) {
            count++;

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (next != null) {
            head.next = printReverseRecursive(next, i);
        }

        return prev;
    }
}
