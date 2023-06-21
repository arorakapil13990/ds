package tree;

public class CheckStructure {
    Node root;

    public static void main(String[] args) {
        CheckStructure p = new CheckStructure();
        CheckStructure q = new CheckStructure();
        p.root = new Node(1);
        p.root.left = new Node(2);
        q.root = new Node(1);
        q.root.right = new Node(2);
        /*p.root = new Node(1);
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
        q.root.right.right.left = new Node(8);*/
        System.out.println(isSameStructure(p.root, q.root));
    }

    // https://leetcode.com/problems/same-tree/submissions/
    private static boolean isSameStructure(Node a, Node b) {
        // 1. both empty
        if (a == null && b == null)
            return true;

        // 2. both non-empty . compare them
        if (a != null && b != null) {
            return
                    (
                            isSameStructure(a.left, b.left) &&
                                    isSameStructure(a.right, b.right)
                                    && (a.data == b.data)
                    );
        }

        // 3. one empty, one not . false
        return false;
    }

}

