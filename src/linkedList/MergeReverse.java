package linkedList;

public class MergeReverse {
    Node head1, head2;

    public Node mergeReverseOrder(Node n, Node m) {

        Node sortedHead;
        if (n.data < m.data) {
            sortedHead = new Node(n.data);
            n = n.next;
        } else {
            sortedHead = new Node(m.data);
            m = m.next;
        }

        while (n != null && m != null) {

            if (n.data < m.data) {
                Node newNode = new Node(n.data);
                newNode.next = sortedHead;
                sortedHead = newNode;
                n = n.next;
            } else {
                Node newNode = new Node(m.data);
                newNode.next = sortedHead;
                sortedHead = newNode;
                m = m.next;
            }
        }

        if (n == null) {
            while (m != null) {
                Node newNode = new Node(m.data);
                newNode.next = sortedHead;
                sortedHead = newNode;
                m = m.next;
            }
        }
        if (m == null) {
            while (n != null) {
                Node newNode = new Node(n.data);
                newNode.next = sortedHead;
                sortedHead = newNode;
                n = n.next;
            }
        }
        return sortedHead;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeReverse m = new MergeReverse();

        m.head1 = new Node(10);
        m.head1.next = new Node(30);
        m.head1.next.next = new Node(50);

        m.head2 = new Node(20);
        m.head2.next = new Node(40);
        m.head2.next.next = new Node(60);

        m.printList(m.reverse(m.head1, m.head2));
    }

    private Node reverse(Node m, Node n) {
        Node res = null, newHead = null, k;
        while (m != null && n != null) {
            if (m.data < n.data) {
                k = new Node(m.data);
                m = m.next;
            } else {
                k = new Node(n.data);
                n = n.next;
            }
            if (res != null) {
                k.next = res;
            }
            res = k;
            newHead = res;
        }

        while (m != null) {
            k = new Node(m.data);
            k.next = res;
            res = k;
            newHead = res;
            m = m.next;
        }

        while (n != null) {
            k = new Node(n.data);
            k.next = res;
            res = k;
            newHead = res;
            n = n.next;
        }

        return newHead;
    }
}
