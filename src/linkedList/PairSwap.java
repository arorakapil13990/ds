package linkedList;

public class PairSwap {

    Node head;


    public void swapNode() {
        Node node = head;

        while (node != null && node.next != null) {
            int data = node.data;
            node.data = node.next.data;
            node.next.data = data;
            node = node.next.next;

        }


    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        PairSwap s = new PairSwap();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(6);
        s.swapNode();
        s.printList(s.head);

    }


}
