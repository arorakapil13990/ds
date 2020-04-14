package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {

    Node root;

    public static void main(String[] args) {
        MinimumDepth p = new MinimumDepth();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        System.out.println(p.findMinimumDepth(p.root));
    }

    private int findMinimumDepth(Node node) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            if (temp != null) {
                if (temp.left == null && temp.right == null) {
                    return count;
                }

                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                count++;
            }

        }
        return count;
    }
}
