package tree;

public class MaxElement {
    Node root;

    private int findMax(Node node) {
        int max = Integer.MIN_VALUE;
        if (node != null) {
            int leftMax = findMax(node.left);
            int rightMax = findMax(node.right);
            max = Math.max(Math.max(leftMax,rightMax),node.data);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxElement p = new MaxElement();
        p.root = new Node(1);
        p.root.left = new Node(2);
        p.root.right = new Node(399);
        p.root.left.left = new Node(48);
        p.root.left.right = new Node(5);
        p.root.right.left = new Node(6);
        p.root.right.right = new Node(7);
        System.out.println(p.findMax(p.root));
    }

}
