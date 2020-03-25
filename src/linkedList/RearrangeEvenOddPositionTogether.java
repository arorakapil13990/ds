package linkedList;

public class RearrangeEvenOddPositionTogether {
    Node head;

    private void reaarange(Node node) {
        int counter = 1;
        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;


        while (node != null) {
            if (counter % 2 == 0) {

                if (evenHead == null) {
                    evenHead = evenTail = node;
                } else {
                    evenTail.next = node;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = oddTail = node;
                } else {
                    oddTail.next = node;
                    oddTail = oddTail.next;
                }
            }
            counter++;
            node = node.next;
        }

        if (oddHead != null) {
            head = oddHead;
            oddTail.next = evenHead;
        } else {
            head = evenHead;
        }
        if (evenTail != null)
            evenTail.next = null;

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
        RearrangeEvenOddPositionTogether d = new RearrangeEvenOddPositionTogether();
        d.addToTail(1);
        d.addToTail(2);
        d.addToTail(3);
        d.addToTail(4);
        d.addToTail(5);

        d.reaarange(d.head);
        d.print(d.head);
    }


}
