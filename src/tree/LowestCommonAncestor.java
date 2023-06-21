package tree;

// https://www.youtube.com/watch?v=F-_1sbnPbWQ
public class LowestCommonAncestor {
    Node root;

    static Node LCA(Node node, int n1, int n2) {
        Node left, right;
        if (node == null) {
            return null;
        }

        if (node.data == n1 || node.data == n2) {
            return node;
        }

        left = LCA(node.left, n1, n2);
        right = LCA(node.right, n1, n2);

        if (left != null && right != null) {
            return node;
        } else {
            return left != null ? left : right;
        }
    }
    public static void main(String[] args) {
        LowestCommonAncestor p = new LowestCommonAncestor();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        System.out.println(LCA(p.root, 5, 4).data);
    }
}
