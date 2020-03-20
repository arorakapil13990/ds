package linkedList;

import java.util.ArrayList;
import java.util.List;

public class ReverseFirstKNode {


    Node head;


    private Node printReverse(Node node, int pos) {
        Node newHead = null;
        List<Integer> lt = new ArrayList<>();
        while (pos > 0) {
            pos--;
            lt.add(node.data);
            node = node.next;
        }

        newHead = node;

        for(Integer i : lt){
            Node n = new Node(i);
            n.next = newHead;
            newHead = n;
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
        ReverseFirstKNode s = new ReverseFirstKNode();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(6);
        s.printList(s.printReverse(s.head, 3));
    }


}
