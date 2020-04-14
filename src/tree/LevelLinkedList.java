package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelLinkedList {
    Node root;

    public static void main(String[] args) {
        LevelLinkedList p = new LevelLinkedList();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.createLevelLinkedList(p.root);
    }

    private void createLevelLinkedList(Node node) {

        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);
        List<Integer> listAtLevel = new ArrayList<>();
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp != null) {
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
                listAtLevel.add(temp.data);

            } else {
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                list.add(listAtLevel);
                listAtLevel = new ArrayList<>();
            }
        }

        list.stream().forEach(e -> System.out.println(e));

    }


}
