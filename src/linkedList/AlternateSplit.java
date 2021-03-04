package linkedList;

public class AlternateSplit {

    Node head, head1, head2;

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AlternateSplit a = new AlternateSplit();

        a.head = new Node(1);
        a.head.next = new Node(2);
        a.head.next.next = new Node(3);
        a.head.next.next.next = new Node(4);
        a.head.next.next.next.next = new Node(5);
        a.head.next.next.next.next.next = new Node(6);
        a.splitNode(a.head);
        a.printList(a.head);
        a.printList(a.head1);
        a.printList(a.head2);

    }

    private void split(Node node) {
        int counter = 1;
        while (node != null) {
            Node k = new Node(node.data);
            if (counter % 2 == 0) {
                if (head2 != null) {
                    k.next = head2;
                }
                head2 = k;
            } else {
                if (head1 != null) {
                    k.next = head1;
                }
                head1 = k;
            }
            counter++;
            node = node.next;

        }
    }

    private void splitNode(Node node) {
        int counter = 1;
        while (node != null) {
            Node k = new Node(node.data);
            if (counter % 2 == 0) {
                if (head1 != null) {
                    k.next = head1;
                }
                head1 = k;
            } else {
                if (head2 != null) {
                    k.next = head2;
                }
                head2 = k;
            }
            node = node.next;
            counter++;
        }
    }

}
