package tree;

public class CheckBST {
    Node root;


    private static boolean isBST(Node node, Node left, Node right) {

        if (node == null) {
            return true;
        }

        if (left != null && left.data >= node.data) {
            return false;
        }

        if (right != null && right.data <= node.data) {
            return false;
        }

        return isBST(node.left, left, node) && isBST(node.right, node, right);
    }

    public static void main(String[] args) {
        CheckBST c = new CheckBST();
        CheckBST tree = new CheckBST();
       /* tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        System.out.println(isBST(tree.root,null,null));*/

        c.root = new Node(3);
        c.root.left = new Node(2);
        c.root.right = new Node(5);
        c.root.left.left = new Node(1);
        c.root.left.right = new Node(4);
        System.out.println(isBST(c.root, null, null));
    }
}
