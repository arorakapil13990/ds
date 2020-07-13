package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrintAllPathsFromRootToLeaf {


    Node root;

    public static void main(String[] args) {
        PrintAllPathsFromRootToLeaf p = new PrintAllPathsFromRootToLeaf();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.right.left = new Node(4);
        p.root.right.left.right = new Node(5);
        //printPaths(p.root);
        List<Integer> res = new ArrayList<>();
        path(p.root, res, 5);
        res.stream().forEach(System.out::print);

    }


    private static void printPaths(Node node) {
        int[] arr = new int[256];
        findPath(node, arr, 0);
    }

    private static void findPath(Node node, int[] arr, int index) {
        if (node == null)
            return;
        arr[index++] = node.data;

        if (node.left == null && node.right == null) {
            IntStream.range(0, index).mapToObj(i -> arr[i]).forEach(System.out::print);
            System.out.println();
        } else {
            findPath(node.left, arr, index);
            findPath(node.right, arr, index);
        }
    }


    private static boolean path(Node node, List<Integer> list, int num) {
        if (node == null) return false;
        list.add(node.data);
        if (node.data == num) return true;
        if (path(node.left, list, num) || path(node.right, list, num)) return true;
        list.remove(list.size() - 1);
        return false;
    }


}
