package linkedList;

public class DeleteNAfterM {
    Node head;

    public Node delete(Node node, int m, int n) {
        Node current = node;
        if (node == null) {
            return null;
        }
        int c = 1;
        while (c < m && node != null) {
            node = node.next;
            c++;
        }

        Node mthNode = node;

        node = node.next; // move to the next node i.e node = 3;

        c = 1;
        while (c < n && node != null) {
            node = node.next;
            c++;
        }

        if (node != null) {
            mthNode.next = delete(node.next, m, n);
        }
        return current;
    }


    public void addToTail(int data) {

        if (head == null) {
            head = new Node(data);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data);
        }
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        DeleteNAfterM d = new DeleteNAfterM();
        d.addToTail(1);
        d.addToTail(2);
        d.addToTail(3);
        d.addToTail(4);
        d.addToTail(5);
        d.addToTail(6);
        d.addToTail(7);
        d.addToTail(8);
        d.addToTail(9);
        d.addToTail(10);
        d.delete(d.head, 2, 3);
        d.print(d.head);

    }
}
