package linkedList;

import java.util.Stack;

public class AlternateMinMax {
    Node head;

    public void rearrange(Node node) {

        Node current = null;
        InsertionSort i = new InsertionSort();
        Node sorted = i.insertion(node);

        current = sorted;
        Stack<Node> st = new Stack<>();

        int l = getLength(node);

        while (current != null) {
            st.push(current);
            current = current.next;
        }

        int c = l / 2;
        while (c > 0 && sorted != null) {
            Node next = sorted.next;
            sorted.next = st.pop();
            sorted.next.next = next;
            sorted = next;
            c--;
        }
        sorted.next = null;
        printList(head);
    }

    private int getLength(Node node) {
        int c = 0;
        while (node != null) {
            node = node.next;
            c++;
        }
        return c;
    }


    public void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        AlternateMinMax p = new AlternateMinMax();

        p.head = new Node(1);
        p.head.next = new Node(3);
        p.head.next.next = new Node(2);
        p.head.next.next.next = new Node(7);
        p.head.next.next.next.next = new Node(5);
        p.head.next.next.next.next.next = new Node(6);
        p.head.next.next.next.next.next.next = new Node(4);
        //p.head.next.next.next.next.next.next.next = new Node(4);
        p.rearrange(p.head);

    }

}
