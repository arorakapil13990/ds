package tree;

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
    }

    private int findDepth(Node node) {
        if (node == null) {
            return 0;
        }

        int left = findDepth(node.left);
        int right = findDepth(node.right);

        return left > right ? left + 1 : right + 1;
    }

}
