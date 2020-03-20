package linkedList;

public class ReverseAlternateKNodes {

    Node head;


    private Node reverse(Node node, int i) {

        Node current = node;
        Node prev = null;
        Node next = null;
        int count = 0;

        // reverse i node
        while (count < i && current != null) {
            count++;

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // point head to i+1 node
        if (node != null) {
            node.next = current;
        }


        // move i node
        count = 0;
        while (count < i -1 && current != null) {
            count++;
            current = current.next;
        }


        if (current != null) {
            current.next = reverse(current.next, i);
        }


        return prev;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseAlternateKNodes s = new ReverseAlternateKNodes();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(6);
        s.head.next.next.next.next.next.next = new Node(7);
        s.head.next.next.next.next.next.next.next = new Node(8);
        s.head.next.next.next.next.next.next.next.next = new Node(9);
        s.printList(s.reverse(s.head, 3));
    }
}
