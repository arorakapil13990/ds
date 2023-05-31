package tree;

import java.util.Stack;

public class PostOrder {
    Node root;


    private static void postorder(Node node) {
        Stack<Node> st = new Stack<>();
        st.push(node);
        Stack<Integer> out = new Stack<>();
        while (!st.isEmpty()) {
            Node temp = st.pop();
            out.push(temp.data);
            if (temp.left != null) {
                st.push(temp.left);
            }
            if (temp.right != null) {
                st.push(temp.right);
            }
        }
        while (!out.isEmpty()){
            System.out.print(out.pop() + " ");
        }

    }

    public static void main(String[] args) {
        PostOrder p = new PostOrder();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        postorder(p.root);
    }
}
