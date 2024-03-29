package linkedList;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    Node head;

    public void removeDuplicates(Node current) {
        HashSet<Integer> hs = new HashSet<>();
        Node prev = current;
        while (current.next != null) {
            if (!hs.add(current.data)) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        if (!hs.add(current.data)) {
            prev.next = null;
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
        RemoveDuplicates r = new RemoveDuplicates();
        /*r.head = new Node(1);
        r.head.next = new Node(2);
        r.head.next.next = new Node(1);
        r.head.next.next.next = new Node(1);
        r.head.next.next.next.next = new Node(3);
        r.head.next.next.next.next.next = new Node(3);
        r.head.next.next.next.next.next.next = new Node(4);*/

        r.head = new Node(1);
        r.head.next = new Node(4);
        r.head.next.next = new Node(3);
        r.head.next.next.next = new Node(4);
        r.head.next.next.next.next = new Node(4);
        r.head.next.next.next.next.next = new Node(4);
        r.deleteDuplicates(r.head);
        r.printList(r.head);
    }

    private void deleteDuplicates(Node node) {
        Node prev = head;
        Set<Integer> hs = new HashSet<>();
        while (node != null) {
            if (!hs.add(node.data)) {
                prev.next = node.next;
            } else {
                prev = node;
            }
            node = node.next;
        }
    }
}
