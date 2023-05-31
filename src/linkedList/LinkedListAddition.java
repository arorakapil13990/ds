package linkedList;


public class LinkedListAddition {

    Node head1, head2;

    public Node addTwoList(Node first, Node second) {
        int carry = 0;
        int sum = 0;
        Node res = null;
        Node tmp = null;
        Node newHead = null;


        while (first != null || second != null) {

            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = sum / 10;
            sum = sum % 10;

            tmp = new Node(sum);

            if (res == null) {
                res = tmp;
                newHead = res;
            } else {
                res.next= tmp;
                res = res.next;
            }

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }

        }

        if (carry > 0) {
            tmp.next = new Node(carry);
        }

        return newHead;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListAddition l = new LinkedListAddition();

        l.head1 = new Node(7);
        l.head1.next = new Node(5);
        l.head1.next.next = new Node(9);
        l.head1.next.next.next = new Node(4);
        l.head1.next.next.next.next = new Node(6);

        l.head2 = new Node(8);
        l.head2.next = new Node(4);

        Node n = l.addTwoList(l.head1, l.head2);
        l.printList(n);
    }

}
