package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    Node root;

    private void levelOrder(Node node) {

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            Node tmp = q.poll();
            System.out.print(tmp.data + " ");
            if(tmp.left != null){
                q.offer(tmp.left);
            }

            if(tmp.right != null){
                q.offer(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal p = new LevelOrderTraversal();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.levelOrder(p.root);
    }


}
