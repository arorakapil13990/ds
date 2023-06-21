package tree;

public class SubTree {
    Node root1, root2;

    public boolean isSubtree(Node root, Node subRoot) {

        return isSub(root, subRoot);

    }
    private boolean isSub(Node node, Node subNode) {
        if (subNode == null) return true;
        if (node == null) return false;
        if (isIdentical(node, subNode)) {
            return true;
        }
        return isSubtree(node.left, subNode)
                || isSubtree(node.right, subNode);

    }

    private boolean isIdentical(Node a, Node b) {
        if (a == null && b == null) return true;
        if (a != null && b != null) {

            return (isIdentical(a.left, b.left) && isIdentical(a.right, b.right) && a.data == b.data);
        }
        return false;
    }

    public static void main(String[] args) {
        SubTree tree = new SubTree();

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

        tree.root1 = new Node(26);
        tree.root1.right = new Node(3);
        tree.root1.right.right = new Node(3);
        tree.root1.left = new Node(10);
        tree.root1.left.left = new Node(4);
        tree.root1.left.left.right = new Node(30);
        tree.root1.left.right = new Node(6);

        // TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

        tree.root2 = new Node(10);
        tree.root2.right = new Node(6);
        tree.root2.left = new Node(4);
        tree.root2.left.right = new Node(30);
        if (tree.isSubtree(tree.root1, tree.root2))
            System.out.println(
                    "Tree 2 is subtree of Tree 1 ");
        else
            System.out.println(
                    "Tree 2 is not a subtree of Tree 1");
    }
}
