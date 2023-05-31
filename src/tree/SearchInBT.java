package tree;

public class SearchInBT {
    Node root;

    public static void main(String[] args) {
        SearchInBT p = new SearchInBT();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(3);
        p.root.left.left = new Node(4);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        System.out.println(p.search(p.root, 51));
    }

    private boolean search(Node node, int element) {
        if (node != null) {
            if (node.data == element) {
                return true;
            }
            return search(node.left, element) || search(node.right, element);
        }
        return false;
    }
}