package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Depth {

    Node root;

    public static void main(String[] args) {
        Depth p = new Depth();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.root.right.right.right = new Node(8);
        System.out.println(p.findDepth(p.root));
        depthLevelWise(p.root);
    }

    private int findDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = findDepth(node.left);
        int right = findDepth(node.right);

        return left > right ? left + 1 : right + 1;
    }

    private static void depthLevelWise(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        int c = 1;
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            } else {
                if (!q.isEmpty()) {
                    c++;
                    q.add(null);
                }
            }
        }
        System.out.println("Depth :: " + c);
    }


}
