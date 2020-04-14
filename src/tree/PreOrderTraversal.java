package tree;

/*
 *
 * PreOrder  -  Root Left Right
 * InOrder   -  Left Root Right
 * PostOrder -  Left Right Root
 *
 * */

public class PreOrderTraversal {
    Node root;

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        PreOrderTraversal p = new PreOrderTraversal();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.preOrder(p.root);
    }
}
