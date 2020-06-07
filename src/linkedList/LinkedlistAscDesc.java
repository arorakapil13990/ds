package linkedList;

// Sort a linked list that is sorted alternating ascending and descending orders?
public class LinkedlistAscDesc {
    Node head;

    private Node rearrange(Node node) {
        Node even = null, evenHead = null;
        Node odd = null, oddHead = null;

        int counter = 1;

        while (node != null) {
            if (counter % 2 == 0) {
                if (evenHead == null) {
                    evenHead = even = new Node(node.data);
                } else {
                    even.next = new Node(node.data);
                    even = even.next;
                }

            } else {

                if (oddHead == null) {
                    oddHead = odd = new Node(node.data);
                } else {
                    odd.next = new Node(node.data);
                    odd = odd.next;
                }
            }
            node = node.next;
            counter++;
        }
        evenHead = reverse(evenHead);
        even = evenHead;
        odd = oddHead;
        Node res = null, newHead = null;
        if (odd.data < even.data) {
            res = odd;
            odd = odd.next;
        } else {
            res = even;
            even = even.next;
        }
        newHead = res;

        while (even != null && odd != null) {
            if (odd.data < even.data) {
                res.next = odd;
                res = res.next;
                odd = odd.next;
            } else {
                res.next = even;
                res = res.next;
                even = even.next;
            }
        }

        if (even != null) {
            res.next = even;
        }
        if (odd != null) {
            res.next = odd;
        }

        return newHead;
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

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }

    public static void main(String[] args) {
        LinkedlistAscDesc d = new LinkedlistAscDesc();
        d.addToTail(10);
        d.addToTail(40);
        d.addToTail(53);
        d.addToTail(30);
        d.addToTail(67);
        d.addToTail(12);
        d.addToTail(89);

        d.print(d.rearrange(d.head));
    }


}
