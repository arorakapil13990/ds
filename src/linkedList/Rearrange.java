package linkedList;

import java.util.Stack;

public class Rearrange {
    Node head;

    private void rearrangeLL(Node node) {

        Node current = node;
        int l = getLength(current);

        Stack<Node> st = new Stack<>();

        while (current != null) {
            st.push(node);
            current = current.next;
        }

        int c = l / 2;

        while (c > 0 && node != null) {
            Node next = node.next;
            node.next = st.pop();
            node.next.next=next;
            node = next;
            c--;
        }
        node.next=null;
    }

    private int getLength(Node node) {
        int c = 0;
        while (node != null) {
            node = node.next;
            c++;
        }
        return c;
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
        Rearrange d = new Rearrange();
        d.addToTail(1);
        d.addToTail(2);
        d.addToTail(3);
        d.addToTail(4);
        d.addToTail(5);
        d.addToTail(6);
        d.addToTail(7);
        d.addToTail(8);

        d.rearrangeLL(d.head);
        d.print(d.head);
    }


}
