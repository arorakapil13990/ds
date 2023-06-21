package tree;

/*
 *
 * PreOrder  -  Root Left Right
 * InOrder   -  Left Root Right
 * PostOrder -  Left Right Root
 *
 * */

import java.util.Stack;

public class PreOrder {
    Node root;

    public static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private static void preorder(Node node) {
        System.out.println();
        Stack<Node> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node temp = st.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        PreOrder p = new PreOrder();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.preOrder(p.root);
        preorder(p.root);
    }
}

