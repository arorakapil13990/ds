package tree;

public class CheckStructure {
    Node root;

    public static void main(String[] args) {
        CheckStructure p = new CheckStructure();
        CheckStructure q = new CheckStructure();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);

        q.root = new Node(1);
        q.root.left = new Node(2);
        q.root.right = new Node(3);
        q.root.left.left = new Node(4);
        q.root.left.right = new Node(5);
        q.root.right.left = new Node(6);
        q.root.right.right = new Node(7);
        q.root.right.right.left = new Node(8);
        System.out.println(checkStructurallySameTree(p.root,q.root));
    }

    private static   boolean checkStructurallySameTree(Node n1, Node n2){
        if(n1 == null && n2 == null){
            return true;
        }

        if(n1 == null || n2 == null){
            return false;
        }
        return checkStructurallySameTree(n1.left,n2.right) && checkStructurallySameTree(n1.right,n2.left);
    }
}
