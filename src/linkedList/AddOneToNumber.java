package linkedList;

public class AddOneToNumber {
    Node head;


    public void addOne(Node node) {
        Node tmp = null;
        Node res = null;
        Node newHead = null;

        int sum = 0;
        int carry = 1;

        node = reverse(node);

        while (node != null) {

            sum = carry + node.data;
            carry = sum / 10;
            sum = sum % 10;

            tmp = new Node(sum);
            if (res == null) {
                res = tmp;
                newHead = res;
            } else {
                res.next = tmp;
                res = res.next;
            }

            node = node.next;
        }

        if (carry > 0)
            res.next = new Node(carry);
        head = reverse(newHead);
    }

    private Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        AddOneToNumber a = new AddOneToNumber();

        a.head = new Node(1);
        a.head.next = new Node(9);
        a.head.next.next = new Node(9);
        a.head.next.next.next = new Node(9);
        a.addOne(a.head);
        a.print(a.head);

    }
}
