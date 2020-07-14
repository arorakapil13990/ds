package tree;


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SumVerticalLevel {

    Node root;


    public static void main(String[] args) {
        SumVerticalLevel c = new SumVerticalLevel();
        c.root = new Node(1);
        c.root.left = new Node(2);
        c.root.right = new Node(3);
        c.root.left.left = new Node(4);
        c.root.left.right = new Node(5);
        c.root.right.left = new Node(6);
        c.root.right.right = new Node(7);
        c.root.right.right.left = new Node(8);
        c.root.right.right.right = new Node(9);
        printVerticalOrder(c.root);
        System.out.println("---------");
        recursive(c.root);
    }

    static class Pair<U, V> {
        private U node;
        private V hd;

        public Pair(U node, V hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private static void recursive(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        recursiveVerticalOrder(map,root,0);
        map.values().stream().forEach(System.out::println);
    }

    static void recursiveVerticalOrder(Map<Integer, Integer> map, Node node, int hd) {
        if (node == null) {
            return;
        }
        if (map.containsKey(hd)) {
            map.put(hd, map.get(hd) + node.data);
        } else {
            map.put(hd, node.data);
        }
        recursiveVerticalOrder(map, node.left, hd - 1);
        recursiveVerticalOrder(map, node.right, hd + 1);
    }

    private static void printVerticalOrder(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair<Node, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Node temp = q.peek().node;
            int hd = q.peek().hd;
            q.poll();

            if (temp != null) {
                if (map.containsKey(hd)) {
                    map.put(hd, map.get(hd) + temp.data);
                } else {
                    map.put(hd, temp.data);
                }

                if (temp.left != null) {
                    q.add(new Pair<>(temp.left, hd - 1));
                }

                if (temp.right != null) {
                    q.add(new Pair<>(temp.right, hd + 1));
                }
            }
        }
        map.values().stream().forEach(System.out::println);
    }
}
