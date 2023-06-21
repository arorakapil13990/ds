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
       // p.createLevelLinkedList(p.root);
        p.levelOrder(p.root);
    }
    // fast
    public void levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return;
        List<Node> list = new ArrayList<Node>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Node> tplist = new ArrayList<Node>();
            List<Integer> level = new ArrayList<Integer>();
            while (!list.isEmpty()) {
                Node node = list.remove(0);
                level.add(node.data);
                if (node.left != null) tplist.add(node.left);
                if (node.right != null) tplist.add(node.right);
            }
            result.add(level);
            list = tplist;
        }
        result.stream().forEach(e -> System.out.println(e));
        ;
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


/*
class Solution {
    private List<Node> tplist;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;
        List<Node> list=new ArrayList<Node>();
        list.add(root);
        while(!list.isEmpty())
        {
            List<Node> tplist= new ArrayList<Node>();
            List<Integer> level=new ArrayList<Integer>();
            while(!list.isEmpty())
            {
                Node node=list.remove(0);
                level.add(node.data);
                if(node.left!=null) tplist.add(node.left);
                if(node.right!=null) tplist.add(node.right);
            }
            result.add(level);
            list=tplist;
        }
        return result;
    }
}*/
