package linkedList;

public class SegregateEvenOdd {
    Node head;


    private void segregateEvenOddLinkedList(Node node) {
        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;


        while (node != null) {
            if (node.data % 2 == 0) {

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
            node = node.next;
        }

        evenTail.next = oddHead;
        if (oddTail != null)
            oddTail.next = null;
        head = evenHead;

    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        SegregateEvenOdd s = new SegregateEvenOdd();
        s.head = new Node(8);
        s.head.next = new Node(20);
        s.head.next.next = new Node(10);
        /*s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(5);
        s.head.next.next.next.next.next = new Node(7);*/
        s.segregateEvenOddLinkedList(s.head);
        s.printList(s.head);

    }

}

