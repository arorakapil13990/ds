package linkedList;

public class PartitionByX {

    Node head;

    public Node partition(Node node, int x) {

        Node smallestHead = null, smallestLast = null;
        Node equalHead = null, equalLast = null;
        Node greatestHead = null, greatestLast = null;

        while (node != null) {
            if (node.data < x) {

                if (smallestHead == null) {
                    smallestHead = smallestLast = node;
                } else {
                    smallestLast.next = node;
                    smallestLast = smallestLast.next;
                }

            } else if (node.data == x) {
                if (equalHead == null) {
                    equalHead = equalLast = node;
                } else {
                    equalLast.next = node;
                    equalLast = equalLast.next;
                }
            } else {
                if (greatestHead == null) {
                    greatestHead = greatestLast = node;
                } else {
                    greatestLast.next = node;
                    greatestLast = greatestLast.next;
                }
            }
            node = node.next;
        }

        if (greatestLast != null) {
            greatestLast.next = null;
        }


        if (smallestHead == null) {
            if (equalHead == null) {
                return greatestHead;
            }
            equalLast.next = greatestHead;
            return equalHead;
        }

        if (equalHead == null) {
            if (greatestHead == null) {
                return smallestLast;
            }
            smallestLast.next = greatestHead;
            return smallestHead;
        }

        smallestLast.next = equalHead;
        equalLast.next = greatestHead;

        return smallestHead;
    }

    public void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        PartitionByX p = new PartitionByX();

        p.head = new Node(1);
        p.head.next = new Node(4);
        p.head.next.next = new Node(3);
        p.head.next.next.next = new Node(2);
        p.head.next.next.next.next = new Node(5);
        p.head.next.next.next.next.next = new Node(2);
        p.head.next.next.next.next.next.next = new Node(3);

        Node n = p.partition(p.head, 3);
        p.printList(n);
    }
}
