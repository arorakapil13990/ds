package linkedList;

public class RemoveDuplicateSortedList {

    Node head;


    private void removeDuplicate(Node node) {
        Node current = node;
        while (node != null) {
            while (current != null && current.data == node.data) {
                current = current.next;
            }
            node.next = current;
            node = current;
        }
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        RemoveDuplicateSortedList s = new RemoveDuplicateSortedList();
        s.head = new Node(1);
        s.head.next = new Node(1);
        s.head.next.next = new Node(3);
        s.head.next.next.next = new Node(4);
        s.head.next.next.next.next = new Node(4);
        s.head.next.next.next.next.next = new Node(4);
        s.removeDuplicate(s.head);
        s.printList(s.head);

    }

    void duplicates(Node node) {
        Node pre = node;
        while (node != null) {
            while (node != null && node.next != null && node.data == node.next.data) {
                node = node.next;
            }
            node = node.next;
            pre.next = node;
            pre = node;
        }
    }


}
