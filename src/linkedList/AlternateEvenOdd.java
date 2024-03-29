package linkedList;

import java.util.Stack;

public class AlternateEvenOdd {

    Node head;

    public Node alternate(Node node) {
        Node newHead = null;
        Node res = null;

        Stack<Integer> even = new Stack<>();
        Stack<Integer> odd = new Stack<>();

        while (node != null) {
            if (node.data % 2 == 0) {
                even.push(node.data);
            } else {
                odd.push(node.data);
            }
            node = node.next;
        }

        int counter = 1;
        while (!odd.isEmpty() && !even.isEmpty()) {
            if (res == null) {
                res = newHead = new Node(even.pop());
            } else {
                if (counter % 2 == 0) {
                    res.next = new Node(odd.pop());
                } else {
                    res.next = new Node(even.pop());
                }
                res = res.next;

            }
            counter++;
        }
        while (!even.isEmpty()) {
            res.next = new Node(even.pop());
            res = res.next;
        }
        while (!odd.isEmpty()) {
            res.next = new Node(odd.pop());
            res = res.next;
        }
        return newHead;
    }


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AlternateEvenOdd a = new AlternateEvenOdd();

        a.head = new Node(11);
        a.head.next = new Node(20);
        a.head.next.next = new Node(40);
        a.head.next.next.next = new Node(55);
        a.head.next.next.next.next = new Node(77);
        a.head.next.next.next.next.next = new Node(80);
        a.head.next.next.next.next.next.next = new Node(30);
        a.head.next.next.next.next.next.next.next = new Node(60);

        a.printList(a.alternate(a.head));

    }

}
