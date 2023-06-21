package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertANode {

    Node root;


    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        InsertANode p = new InsertANode();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.insert(p.root, 51);

        p.inOrder(p.root);

        System.out.println(" --------- ");

        p.insert(p.root, 32);
        p.inOrder(p.root);

    }

    private void insert(Node node, int element) {

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left != null) {
                q.offer(temp.left);
            } else {
                temp.left = new Node(element);
                break;
            }

            if (temp.right != null) {
                q.offer(temp.right);
            } else {
                temp.right = new Node(element);
                break;
            }

        }
    }

    public void insertRecursive(Node root, int data){
        if(root == null){
            root = new Node(data);
        }else {
            helper(root,data);
        }
    }

    private void helper(Node node, int data) {
        if(node.left == null){
            node.left = new Node(data);
        }else {
            helper(node.right,data);
        }

        if(node.right == null){
            node.right = new Node(data);
        }else {
            helper(node.left,data);
        }
    }
}
