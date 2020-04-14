package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderReversal {

    Node root;

    public static void main(String[] args) {
        LevelOrderReversal p = new LevelOrderReversal();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.levelTraversal(p.root);
    }


    private void levelTraversal(Node node) {

        Queue<Node> q = new LinkedList<>();
        Stack<Node> s = new Stack<>();
        q.offer(node);
        while (!q.isEmpty()) {

            Node tmp = q.poll();

            if (tmp.right != null) {
                q.offer(tmp.right);
            }
            if (tmp.left != null) {
                q.offer(tmp.left);
            }

            s.push(tmp);
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop().data + " ");
        }

    }


}
