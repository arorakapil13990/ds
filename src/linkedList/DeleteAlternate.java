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
        a.delete(a.head);
        a.printList(a.head);

    }

    private void delete(Node node) {

        Node pre = null;
        int counter = 1;
        while (node != null) {
            if (counter % 2 == 0) {
                pre.next=node.next;
            }
            pre = node;
            node = node.next;
            counter++;
        }
    }
}
