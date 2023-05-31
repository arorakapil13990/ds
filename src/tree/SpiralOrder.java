package tree;

import java.util.Stack;

public class SpiralOrder {
    Node root;

    static void spiral(Node node) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node temp = s1.pop();
                System.out.print(temp.data +" ");
                if (temp.right != null) {
                    s2.add(temp.right);
                }
                if (temp.left != null) {
                    s2.add(temp.left);
                }
            }

            while (!s2.isEmpty()) {
                Node temp = s2.pop();
                System.out.print(temp.data +" ");
                if (temp.left != null) {
                    s1.add(temp.left);
                }
                if (temp.right != null) {
                    s1.add(temp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        SpiralOrder p = new SpiralOrder();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(7);
        p.root.left.right = new Node(6);
        p.root.right.left = new Node(5);
        p.root.right.right = new Node(4);
        spiral(p.root);
    }
}
