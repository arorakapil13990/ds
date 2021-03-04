package linkedList;

public class DeleteAlternate {

    Node head;

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteAlternate a = new DeleteAlternate();

        a.head = new Node(1);
        a.head.next = new Node(2);
        a.head.next.next = new Node(3);
        a.head.next.next.next = new Node(4);
        a.head.next.next.next.next = new Node(5);
        a.head.next.next.next.next.next = new Node(6);
        /*a.delete(a.head);
        a.printList(a.head);*/
        /*a.deleteAlternate(a.head);
        a.printList(a.head);*/

        //a.printList(a.recursiveDelete(a.head));

        a.deleteAlternate(a.head);
        a.printList(a.head);
    }

    private Node recursiveDelete(Node head) {

        if (head == null) {
            return null;
        }
        Node node = head.next;

        if (node == null) {
            return null;
        }
        head.next = node.next;

        head.next = recursiveDelete(head.next);

        return head;
    }

    private void deleteAlternate(Node node) {
        Node pre = node;
        node = node.next;

        while (pre != null && node != null) {
            pre.next = node.next;
            pre = node.next;
            if (pre != null) {
                node = pre.next;
            }
        }

    }

    private void deleteNode(Node node) {
        Node pre = node;
        Node current = node.next;

        while (current != null) {
            pre.next = current.next;
            pre = current.next;
            if (current.next != null) {
                current = current.next.next;
            } else {
                current = null;
            }
        }
    }


    private void delete(Node node) {

        Node pre = null;
        int counter = 1;
        while (node != null) {
            if (counter % 2 == 0) {
                pre.next = node.next;
            }
            pre = node;
            node = node.next;
            counter++;
        }
    }
}
