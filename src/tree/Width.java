package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Width {

    Node root;

    public static void main(String[] args) {
        Width tree = new Width();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(88);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);

        tree.findWidth(tree.root);

        width(tree.root);
    }


    private static void width(Node node) {

        int max = Integer.MIN_VALUE;
        int h = getHeight(node);

        for (int i = 0; i < h; i++) {
            int temp = depth(node, i);
            max = Math.max(temp, max);
        }
        System.out.println("Width :: " + max);
    }

    private static int depth(Node node, int level) {

        if (node == null) {
            return 0;
        }
        if (level == 0) {
            return 1;
        }

        return depth(node.left, level - 1) + depth(node.right, level - 1);
    }

    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return Math.max(left, right) + 1;
    }


    private void findWidth(Node node) {

        Queue<Node> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int maxAtLevel = 0;

        q.offer(node);
        q.offer(null);

        while (!q.isEmpty()) {

            Node temp = q.poll();
            if (temp != null) {
                maxAtLevel++;

                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }
            } else {
                max = Math.max(max, maxAtLevel);
                if (!q.isEmpty()) {
                    maxAtLevel = 0;
                    q.offer(null);
                }
            }

        }

        System.out.println("Width :: " + max);

    }
}
