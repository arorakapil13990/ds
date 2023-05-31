package linkedList;

import java.util.HashMap;
import java.util.Map;

public class SortZeroOneTwo {
    Node head;


    public void sort(Node node) {

        int[] count = {0, 0, 0};

        while (node != null) {
            count[node.data]++;
            node = node.next;
        }

        node = head;
        int i = 0;
        while (node != null) {
            if (count[i] == 0) { // if count at i index is 0 then increment the counter
                i++;
            } else {
                node.data = i;
                --count[i];
                node = node.next;
            }
        }
    }


    public void addToTail(Node node, int data) {
        Node n = new Node(data);
        if (node == null) {
            head = n;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = n;
        }
    }

    private void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        SortZeroOneTwo s = new SortZeroOneTwo();

        s.addToTail(s.head, 1);
        s.addToTail(s.head, 1);
        s.addToTail(s.head, 2);
        s.addToTail(s.head, 0);
        s.addToTail(s.head, 2);
        s.addToTail(s.head, 0);
        s.addToTail(s.head, 1);
        s.sort(s.head);
        s.print(s.head);
    }
}
