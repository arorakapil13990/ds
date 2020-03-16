package linkedList;

public class InsertNodeInSorted {

    Node head;

    public void insertNode(int data, Node node) {

        Node n = new Node(data);
        Node prev = node;
        if (node.data > data) {
            n.next = node;
            head = n;
            return;
        }


        while (node != null) {
            if (node.data < data) {
                prev = node;
                node = node.next;
            } else {
                prev.next = n;
                n.next = node;
                break;
            }
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
        InsertNodeInSorted i = new InsertNodeInSorted();

        i.head = new Node(1);
        i.head.next = new Node(2);
        i.head.next.next = new Node(4);
        i.head.next.next.next = new Node(5);

        i.insertNode(3, i.head);
        i.printList(i.head);

    }
}
