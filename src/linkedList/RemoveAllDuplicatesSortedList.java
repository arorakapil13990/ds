package linkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RemoveAllDuplicatesSortedList {
    Node head;

    // more optimised
    private Node delDup(Node head) {
        int c = 0;
        Node res = null;
        Node newHead = null;

        Node pre = head;
        Node current = head;

        while (current != null) {
            while (current != null && current.data == pre.data) {
                current = current.next;
                c++;
            }
            if (c == 1) {
                if (res == null) {
                    res = newHead = new Node(pre.data);
                } else {
                    res.next = new Node(pre.data);
                    res = res.next;
                }
            }
            pre = current;
            c = 0;
        }
        return newHead;
    }


    private void removeDuplicate(Node node) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
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
        /*s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(4);
        s.head.next.next.next.next.next = new Node(4);
        s.head.next.next.next.next.next.next = new Node(5);*/
        // s.removeDuplicate(s.head);

        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(2);
        s.printList(s.delDup(s.head));
    }

    private Node deleteDuplicates(Node head) {

        Map<Integer, Integer> map = new HashMap<>();
        Node node = head;

        while (node != null) {
            map.merge(node.data, 1, Integer::sum);
            node = node.next;
        }
        //map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        Node n = head, res = null, newHead = null;
        while (n != null) {
            if (map.get(n.data) == 1) {
                if (res == null) {
                    res = newHead = new Node(n.data);
                } else {
                    res.next = new Node(n.data);
                    res = res.next;
                }
            }
            n = n.next;
        }

        return newHead;
    }


}
