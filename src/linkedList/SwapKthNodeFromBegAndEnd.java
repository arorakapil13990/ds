package linkedList;

/*
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning
and the kth node from the end (the list is 1-indexed).

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
*/

public class SwapKthNodeFromBegAndEnd {
    Node head;

    Node reverse(Node node, int k){
        Node x = node, y = node, t = node;

        // Until we reach k-th node from beginning
        while (k > 1) {
            x = x.next;
            t = t.next;
            k--;
        }

        // Until pointer t reach last need
        while (t.next != null) {
            y = y.next;
            t = t.next;
        }

        // Swap values at both the nodes
        int temp = x.data;
        x.data = y.data;
        y.data = temp;

        return node;
    }
    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        SwapKthNodeFromBegAndEnd s = new SwapKthNodeFromBegAndEnd();
        /*s.head = new Node(7);
        s.head.next = new Node(9);
        s.head.next.next = new Node(6);
        s.head.next.next.next = new Node(6);
        s.head.next.next.next.next = new Node(7);
        s.head.next.next.next.next.next = new Node(8);
        s.head.next.next.next.next.next.next = new Node(3);
        s.head.next.next.next.next.next.next.next = new Node(0);
        s.head.next.next.next.next.next.next.next.next = new Node(9);
        s.head.next.next.next.next.next.next.next.next.next = new Node(5);*/

        s.head = new Node(1);
        s.head.next = new Node(2);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.printList(s.reverse(s.head, 2));

    }

}
