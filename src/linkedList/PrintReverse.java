package linkedList;

public class PrintReverse {
    Node head;

    public static void main(String[] args) {
        PrintReverse s = new PrintReverse();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(6);
        s.printReverse(s.head);
    }

    private void printReverse(Node node) {
        if (node == null) {
            return;
        }
        printReverse(node.next);
        System.out.println(node.data);
    }
}
