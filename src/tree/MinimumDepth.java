package tree;
// https://www.techiedelight.com/find-minimum-depth-binary-tree/

public class MinimumDepth {

    Node root;

    public static void main(String[] args) {
        MinimumDepth p = new MinimumDepth();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        System.out.println(p.findMinDepth(p.root));
    }


    public  int findMinDepth(Node root)
    {
        // base case
        if (root == null) {
            return 0;
        }

        // find the minimum depth of the left subtree
        int l = findMinDepth(root.left);

        // find the minimum depth of the right subtree
        int r = findMinDepth(root.right);

        // if the left child does not exist, consider the depth
        // returned by the right subtree
        if (root.left == null) {
            return 1 + r;
        }

        // if the right child does not exist, consider the depth
        // returned by the left subtree
        if (root.right == null) {
            return 1 + l;
        }

        // otherwise, choose the minimum depth returned by the
        // left and right subtree
        return Integer.min(l, r) + 1;
    }
}
