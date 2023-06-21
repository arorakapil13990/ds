package tree;

public class SumOfBinaryTree {
    Node root;

    private static int sum(Node node) {
        if (node == null)
            return 0;
        return node.data + sum(node.left) + sum(node.right);
    }

    public static void main(String[] args) {
        SumOfBinaryTree c = new SumOfBinaryTree();
        c.root = new Node(3);
        c.root.left = new Node(2);
        c.root.right = new Node(5);
        c.root.left.left = new Node(1);
        c.root.left.right = new Node(4);
        System.out.println(sum(c.root));
    }
}

