package tree;

public class HasPathSum {

    Node root;

    public static void main(String[] args) {
        HasPathSum tree = new HasPathSum();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(10);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
        System.out.println(hasPathSum(tree.root, 14));
    }

    private static boolean hasPathSum(Node node, int sum) {
        if (node == null) {
            return false;
            //return sum == 0;
        }
        if (node.left == null && node.right == null && sum == 0) {
            return true;
        } else {
            return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
        }
    }
}
