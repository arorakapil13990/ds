package tree;

public class CreateBSTFromArray {
    private Node createBST(int a[], int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;

        Node n = new Node(a[mid]);
        n.left = createBST(a, start, mid - 1);
        n.right = createBST(a, mid + 1, end);
        return n;
    }

    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        CreateBSTFromArray c = new CreateBSTFromArray();
        c.preOrder(c.createBST(a, 0, a.length - 1));
    }
}
