package tree;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class TreeSerialization {
    Node root;

    public static void main(String[] args) {
        TreeSerialization p = new TreeSerialization();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.right.left = new Node(4);
        p.root.right.right = new Node(5);
       // System.out.println(p.serialize(p.root));
       // System.out.println(p.deserialize("1 2 3 n n 4 5 n n n n").data);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrder(p.deserialize("1 2 3 n n 4 5 n n n n"));
    }

    public String serialize(Node root) {

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node == null){
                sb.append("n ");
                continue;
            }
            sb.append(node.data + " ");
            q.offer(node.left);
            q.offer(node.right);

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data == "") return null;
        String[] arr = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        //System.out.print(arr[0]);
        if(arr[0].equals("n")) return null;
        Node root = new Node(Integer.parseInt(arr[0]));
        q.offer(root);
        for(int i =1;i< arr.length;i++){
            Node node = q.poll();
            if(!arr[i].equals("n")){
                Node left = new Node(Integer.parseInt(arr[i]));
                node.left = left;
                q.offer(left);
            }
            if(!arr[++i].equals("n")){
                Node right = new Node(Integer.parseInt(arr[i]));
                node.right = right;
                q.offer(right);
            }

        }

        return root;
    }
}
