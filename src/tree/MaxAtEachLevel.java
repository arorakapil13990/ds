package tree;

import java.util.*;

// https://leetcode.com/problems/find-largest-value-in-each-tree-row/submissions/961878722/
public class MaxAtEachLevel {
    Node root;

    public static void main(String[] args) {
        MaxAtEachLevel p = new MaxAtEachLevel();
        p.root = new Node(1);
        p.root.left = new Node(3);
        p.root.right = new Node(2);
        p.root.left.left = new Node(5);
        p.root.left.right = new Node(3);
        p.root.right.left = new Node(9);
        p.max(p.root);
    }

    // accepted in leetcode
    public void max(Node root) {
        List<Integer> result = new ArrayList<>();
        List<Node> list = new ArrayList<Node>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Node> Tplist = new ArrayList<>();
            //List<Integer> level = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            while (!list.isEmpty()) {
                Node node = list.remove(0);
                if(max < node.data){
                    max = node.data;
                }
              //  level.add(node.data);
                if (node.left != null) Tplist.add(node.left);
                if (node.right != null) Tplist.add(node.right);
            }
            result.add(max);
            list = Tplist;
        }
        result.forEach(System.out::println);
    }


    public void maxAtLevel(Node node) {
        List<Integer> maxList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp != null) {
                if (max < temp.data) {
                    max = temp.data;
                    ;
                }
                if (temp.left != null) {
                    q.offer(temp.left);
                }

                if (temp.right != null) {
                    q.offer(temp.right);
                }

            } else {
                if (!q.isEmpty()) {
                    maxList.add(max);
                    max = Integer.MIN_VALUE;
                    q.offer(null);
                }
            }

        }
        maxList.add(max);
        maxList.forEach(System.out::println);
    }
}
