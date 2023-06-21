package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
//https://www.techiedelight.com/construct-binary-tree-from-inorder-preorder-traversal/
public class CreateBinaryTreeFromInAndPre {


    // Construct a binary tree from inorder and preorder traversals.
    // This function assumes that the input is valid, i.e., given
    // inorder and preorder sequence forms a binary tree.
    static Node construct(int[] in, int[] pre) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, in.length).forEach(i -> {
            map.put(in[i], i);
        });
        return createTree(0, in.length - 1, pre, new AtomicInteger(0), map);
    }

    // Recursive function to construct a binary tree from a given
    // inorder and preorder sequence
    private static Node createTree(int start, int end, int[] pre, AtomicInteger atomicInteger, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        // The next element in `preorder[]` will be the root node of subtree
        // formed by sequence represented by `inorder[start, end]`
        Node root = new Node(pre[atomicInteger.getAndIncrement()]);

        // get the root node index in sequence `inorder[]` to determine the
        // left and right subtree boundary
        int index = map.get(root.data);

        // recursively construct the left subtree
        root.left = createTree(start, index - 1, pre, atomicInteger, map);

        // recursively construct the right subtree
        root.right = createTree(index + 1, end, pre, atomicInteger, map);

        // return current node
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};
        Node node = construct(inorder, preorder);
        PreOrder.preOrder(node);
    }
}
