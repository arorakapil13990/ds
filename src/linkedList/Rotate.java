package linkedList;
 // to the left
public class Rotate {


    // to the right https://www.geeksforgeeks.org/clockwise-rotation-of-linked-list/

    Node head;

    public Node rotateByK(Node node, int k) {

        Node current = node;
        while (k - 1 > 0 && current != null) {
            k--;
            current = current.next;
        }

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }
        current.next=head;
        head = kthNode.next;
        kthNode.next=null;
        return head;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Rotate s = new Rotate();
        s.head = new Node(10);
        s.head.next = new Node(20);
        s.head.next.next = new Node(30);
        s.head.next.next.next = new Node(40);
        s.head.next.next.next.next = new Node(50);
        s.head.next.next.next.next.next = new Node(60);

        s.printList(s.rotateByK(s.head, 2));
    }

}
