package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Size {

    Node root;

    public static void main(String[] args) {
        Size p = new Size();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        System.out.println(p.size(p.root));
        p.treeSize(p.root);
    }

    private int size(Node node) {

        if (node == null) {
            return 0;
        }
        int left = size(node.left);
        int right = size(node.right);
        return 1 + left + right;
    }

    private void treeSize(Node node){
        int c = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            Node temp = q.poll();
            c++;

            if(temp.left != null){
                q.offer(temp.left);
            }

            if(temp.right != null){
                q.offer(temp.right);
            }

        }
        System.out.println(c);
    }
}
