package tree;

import java.util.stream.IntStream;

public class PrintAllPathsFromRootToLeaf {


    Node root;

    public static void main(String[] args) {
        PrintAllPathsFromRootToLeaf p = new PrintAllPathsFromRootToLeaf();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.root.right.right.right = new Node(8);
        printPaths(p.root);
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
            IntStream.range(0,index).mapToObj(i -> arr[i]).forEach(System.out::print);
            System.out.println();
        }else {
            findPath(node.left,arr,index);
            findPath(node.right,arr,index);
        }


    }
}
