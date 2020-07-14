package tree;

public class PrintAncestorOfNode {

    Node root;

   static boolean findAncestor(Node node, int target){
       if(node == null) return false;

       if(node.data == target) return true;

       if(findAncestor(node.left,target) || findAncestor(node.right,target)){
           System.out.println(node.data);
           return true;
       }
       return false;
   }

    public static void main(String[] args) {
        PrintAncestorOfNode p = new PrintAncestorOfNode();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        findAncestor(p.root,5);
    }
}
