package linkedList;

// this is in pairs
public class ReverseNodeInGroup {
    Node head;


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseNodeInGroup s = new ReverseNodeInGroup();
        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);

        s.printList(s.printReverseRecursive(s.head, 2));
    }


    // this works in pairs
    private Node printReverseRecursive(Node head, int i) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count < i && current != null) {
            count++;

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if (next != null) {
            head.next = printReverseRecursive(current, i);
        }

        return prev;
    }
}


// this works for swapping nodes in Kth group

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*class Solution {

    int length(ListNode node){
        int l =0;

        while(node != null){
            l++;
            node = node.next;
        }
        return l;
    }
    public ListNode reverseKGroup(ListNode head, int k) {



        int count = 0;
        ListNode current = head;

        if(length(current) < k){
            return head;
        }

        ListNode pre= null;
        ListNode next = null;
        while(count< k && current != null){
            count++;
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        if(next != null){
            head.next = reverseKGroup(current,k);
        }
        return pre;
    }
}*/
