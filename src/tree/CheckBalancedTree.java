package tree;

import java.util.concurrent.atomic.AtomicBoolean;

// https://www.youtube.com/watch?v=LU4fGD-fgJQ&t=621s
public class CheckBalancedTree {

    Node root;

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);

        return left > right ? left + 1 : right + 1;
    }


    // O(n2)
    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int diff = Math.abs(getHeight(node.left) - getHeight(node.right));
        if (diff > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);

    }


    //https://www.techiedelight.com/check-given-binary-tree-is-height-balanced-not/
    // O(n)
    // Recursive function to check if given binary tree is height balanced or not
    public static int isHeightBalanced(Node root, AtomicBoolean isBalanced) {
        // base case: tree is empty or tree is not balanced
        if (root == null || !isBalanced.get()) {
            return 0;
        }

        // get height of left subtree
        int left_height = isHeightBalanced(root.left, isBalanced);

        // get height of right subtree
        int right_height = isHeightBalanced(root.right, isBalanced);

        // tree is unbalanced if absolute difference between height of
        // its left subtree and right subtree is more than 1
        if (Math.abs(left_height - right_height) > 1) {
            isBalanced.set(false);
        }

        // return height of subtree rooted at current node
        return Math.max(left_height, right_height) + 1;
    }

    // Main function to check if given binary tree is height balanced or not
    public static boolean isHeightBalanced(Node root) {
        // Using AtomicBoolean as boolean is passed by value in Java
        AtomicBoolean isBalanced = new AtomicBoolean(true);
        isHeightBalanced(root, isBalanced);

        return isBalanced.get();
    }


    public static void main(String[] args) {
        CheckBalancedTree p = new CheckBalancedTree();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        /*p.root.right.right.right = new Node(8);
        p.root.right.right.right.right = new Node(9);*/
        System.out.println(p.isBalanced(p.root));
        System.out.println(isHeightBalanced(p.root));

    }
}
