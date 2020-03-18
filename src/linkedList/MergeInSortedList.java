package linkedList;

public class MergeInSortedList {

    Node head1, head2, sortedNode;


    public Node mergeList(Node n1, Node n2, Node sortedNode) {

        Node new_head = null;

        if (n1.data < n2.data) {
            sortedNode = n1;
            n1 = n1.next;
        } else {
            sortedNode = n2;
            n2 = n2.next;
        }
        new_head = sortedNode;

        while (n1 != null && n2 != null) {

            if (n1.data < n2.data) {
                sortedNode.next = n1;
                sortedNode = n1;
                n1 = n1.next;
            } else {
                sortedNode.next = n2;
                sortedNode = n2;
                n2 = n2.next;
            }
        }

        if (n1 == null) {
            sortedNode.next = n2;
        }

        if (n2 == null) {
            sortedNode.next = n1;
        }

        return new_head;
    }


    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeInSortedList m = new MergeInSortedList();

        m.head1 = new Node(10);
        m.head1.next = new Node(30);
        m.head1.next.next = new Node(50);

        m.head2 = new Node(20);
        m.head2.next = new Node(40);
        m.head2.next.next = new Node(60);
        m.printList(m.mergeList(m.head1, m.head2, m.sortedNode));
    }
}
