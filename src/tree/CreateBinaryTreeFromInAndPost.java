package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
//https://www.techiedelight.com/construct-binary-tree-from-inorder-postorder-traversals/

public class CreateBinaryTreeFromInAndPost {

    static Node construct(int[] in, int[] post) {

        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, in.length).forEach(i -> map.put(in[i], i));

        return construct(0, in.length - 1, new AtomicInteger(post.length - 1), post, map);
    }

    private static Node construct(int start, int end, AtomicInteger atomicInteger, int[] post, Map<Integer, Integer> map) {

        if (start > end) {
            return null;
        }

        Node root = new Node(post[atomicInteger.getAndDecrement()]);
        int index = map.get(root.data);
        root.right = construct(index + 1, end, atomicInteger, post, map);
        root.left = construct(start, index - 1, atomicInteger, post, map);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {4, 2, 7, 8, 5, 6, 3, 1};
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};

        PreOrder.preOrder(construct(inorder, postorder));
    }
}
