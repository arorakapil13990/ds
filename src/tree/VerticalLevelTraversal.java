package tree;


import java.util.*;

/*
 * https://www.youtube.com/watch?v=PQKkr036wRc
 *
 *  Hd = horizontal Distance from left side
 *
 * Root --  Hd = 0
 * Left --  Hd = Hd(of parent) - 1
 * Right -- Hd = Hd(of parent) + 1
 *
 * Algorithm --  Level order traversal + Hashtable
 * */
public class VerticalLevelTraversal {
    Node root;

    static class Pair<U, V> {
        private U first;
        private V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static void insertIntoMap(Map<Integer, List<Integer>> map, int hd, int data) {
        if (!map.containsKey(hd)) {
            map.put(hd, new ArrayList<Integer>());
        }
        map.get(hd).add(data);
    }

    static void printVerticalOrder(Node node) {
        if (node == null) {
            return;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<Node, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(node, 0));

        while (!q.isEmpty()) {
            Node temp = q.peek().first;
            int hd = q.peek().second;
            q.poll();
            insertIntoMap(map, hd, temp.data);

            if (temp.left != null) {
                q.add(new Pair<>(temp.left, hd - 1));
            }

            if (temp.right != null) {
                q.add(new Pair<>(temp.right, hd + 1));
            }
        }

        map.values().stream().forEach(System.out::println);
    }


    public static void main(String[] args) {
        VerticalLevelTraversal c = new VerticalLevelTraversal();
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
        System.out.println();
        recursiveVerticalOrder(c.root);
    }

    static void getVerticalOrder(Node root, int hd,
                                 TreeMap<Integer, List<Integer>> m) {
        if (root == null)
            return;
        List<Integer> list = m.get(hd);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(root.data);
        m.put(hd, list);
        getVerticalOrder(root.left, hd - 1, m);
        getVerticalOrder(root.right, hd + 1, m);
    }

    static void recursiveVerticalOrder(Node root) {
        TreeMap<Integer, List<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, m);
        m.forEach((key, value) -> System.out.println(value));
    }
}
