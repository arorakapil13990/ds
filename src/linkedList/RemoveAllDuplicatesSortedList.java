package linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveAllDuplicatesSortedList {
    Node head;


    private void removeDuplicate(Node node) {


        Map<Integer, Integer> map = new HashMap<>();

        while (node != null) {
            map.merge(node.data, 1, Integer::sum);
            node = node.next;
        }

        Node res = null, newHead = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (res == null) {
                    res = new Node(entry.getKey());
                    newHead = res;
                } else {
                    res.next = new Node(entry.getKey());
                    res = res.next;
                }

            }
        }
        head = newHead;
    }


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        RemoveAllDuplicatesSortedList s = new RemoveAllDuplicatesSortedList();
        s.head = new Node(1);
        s.head.next = new Node(1);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(4);
        s.head.next.next.next.next.next = new Node(4);
        s.head.next.next.next.next.next.next = new Node(5);
        s.removeDuplicate(s.head);
        s.printList(s.head);
    }


}
