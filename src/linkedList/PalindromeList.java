package linkedList;

import java.util.Stack;

public class PalindromeList {

    Node head;


    public void isPalindrome(Node node) {

        Node current = node;
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            stack.push(node.data);
            node = node.next;
        }

        boolean isPalin = true;
        while (!stack.isEmpty()) {
            if (stack.pop() != current.data) {
                isPalin = false;
                break;
            }
            current = current.next;
        }

        if (isPalin) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) {

        PalindromeList p = new PalindromeList();
        p.head = new Node(1);
        p.head.next = new Node(3);
        p.head.next.next = new Node(3);
        p.head.next.next.next = new Node(1);
        p.isPalindrome(p.head);
    }
}
