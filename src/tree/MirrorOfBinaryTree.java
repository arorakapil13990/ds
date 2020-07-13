package tree;

public class MirrorOfBinaryTree {
    Node root;

    private static Node mirror(Node node) {
        Node temp;
        if (node != null) {
            mirror(node.left);
            mirror(node.right);
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return node;
    }
    private static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        MirrorOfBinaryTree c = new MirrorOfBinaryTree();
        c.root = new Node(1);
        c.root.left = new Node(2);
        c.root.right = new Node(3);
        c.root.left.left = new Node(4);
        c.root.left.right = new Node(5);
        preOrder(c.root);
        System.out.println();
        mirror(c.root);
        preOrder(c.root);
    }

}
