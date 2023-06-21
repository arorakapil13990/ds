package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    Node root;

    public void levelOrder(Node node) {

        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()){
            Node tmp = q.poll();
            System.out.print(tmp.data + " ");
            if(tmp.left != null){
                q.offer(tmp.left);
            }
            if(tmp.right != null){
                q.offer(tmp.right);
            }
        }
    }



    public static void main(String[] args) {
        LevelOrderTraversal p = new LevelOrderTraversal();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        p.levelOrder(p.root);
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal/description/

/*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;
        List<TreeNode> list=new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty())
        {
            List<TreeNode> Tplist=new ArrayList<TreeNode>();
            List<Integer> level=new ArrayList<Integer>();
            while(!list.isEmpty())
            {
                TreeNode node=list.remove(0);
                level.add(node.val);
                if(node.left!=null) Tplist.add(node.left);
                if(node.right!=null) Tplist.add(node.right);
            }
            result.add(level);
            list=Tplist;
        }
        return result;

    }*/
}
