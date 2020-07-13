package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CreateBinaryTreeFromInAndPre {
    static Node construct(int[] in, int[] pre) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, in.length).forEach(i -> {
            map.put(in[i], i);
        });
        return createTree(0, in.length - 1, pre, new AtomicInteger(0), map);
    }

    private static Node createTree(int start, int end, int[] pre, AtomicInteger atomicInteger, Map<Integer, Integer> map) {
        if (start > end) {
            return null;
        }
        Node root = new Node(pre[atomicInteger.getAndIncrement()]);
        int index = map.get(root.data);
        root.left = createTree(start, index - 1, pre, atomicInteger, map);
        root.right = createTree(index + 1, end, pre, atomicInteger, map);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 1, 7, 5, 8, 3, 6};
        int[] preorder = {1, 2, 4, 3, 5, 7, 8, 6};
        Node node = construct(inorder, preorder);
        PreOrder.preOrder(node);
    }
}
