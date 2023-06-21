package tree;

/*
* https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
* For each node there can be four ways that the max path goes through the node:
Node only
Max path through Left Child + Node
Max path through Right Child + Node
Max path through Left Child + Node + Max path through Right Child
*
*/

import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathSum {
    int max_sum_path = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        //   root.right = new Node(10);
        /*root.left.left = new Node(-1);
        root.left.right = new Node(-4);
        root.right.left = new Node(-5);
        root.right.right = new Node(-6);
        root.left.right.left = new Node(4);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(4);
        root.right.left.left.right = new Node(-2);*/

        // System.out.println(new MaxPathSum().maxPathSum(root));

        System.out.println(new MaxPathSum().maxPathSum(root));
    }

    public int maxPathSum(Node node) {
        pathSum(node);
        return max_sum_path;
    }

    private int pathSum(Node node) {
        if (node == null) return 0;

        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0, pathSum(node.right));
        max_sum_path = Math.max(max_sum_path, left + right + node.data);

        return Math.max(left, right) + node.data;
    }


    /*public int maxPathSum(Node root) {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Compute and return result
        findMaxUtil(root, res);
        return res.val;
    }


    class Res {
        public int val;
    }
    int findMaxUtil(Node node, Res res)
    {

        // Base Case
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left
        // and right child of root respectively
        int l = findMaxUtil(node.left, res);
        int r = findMaxUtil(node.right, res);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(
                Math.max(l, r) + node.data, node.data);

        // Max Top represents the sum when the Node under
        // consideration is the root of the maxsum path and
        // no ancestors of root are there in max sum path
        int max_top
                = Math.max(max_single, l + r + node.data);

        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);

        return max_single;
    }*/

}
