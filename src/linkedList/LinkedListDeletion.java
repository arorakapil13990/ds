package linkedList;

public class LinkedListDeletion {

    Node head;

    public void insertNode(int data) {

        Node n = new Node(data);

        if (head == null) {
            head = n;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = n;
        }
    }


    public void deleteHead() {
        Node current = head;
        head = current.next;
    }


    public void deleteTail() {
        Node current = head;
        Node prev = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }

    public void deleteGivenNode(int data) {
        Node current = head;
        Node prev = head;

        if (head.data == data) {
            head = head.next;
            return;
        }
        while (current.next != null) {
            if (current.data == data) {
                prev.next = current.next;
                current = null;
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current != null && current.data == data) {
            prev.next = null;
        }

    }


    public void deleteAtPosition(int pos) {
        Node current = head;
        Node prev = head;
        if (pos == 1) {
            head = head.next;
        }
        while (pos - 1 > 0 && current.next != null) {
            prev = current;
            current = current.next;
            pos--;
        }
        prev.next = current.next;
    }

    public void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }


    public static void main(String[] args) {

        LinkedListDeletion l = new LinkedListDeletion();
        l.insertNode(1);
        l.insertNode(2);
        l.insertNode(3);
        l.insertNode(4);
        l.insertNode(5);
        l.insertNode(6);
        l.printList(l.head);
        l.deleteHead();
        l.printList(l.head);
        System.out.println("------");
        l.deleteTail();
        l.printList(l.head);

        l.deleteGivenNode(4);
        l.printList(l.head);

        l.deleteAtPos(3);
        l.printList(l.head);
    }

    private void deleteAtPos(int pos){
        if(pos == 1){
            deleteHead();
        }else {
            Node current = head, pre = null;
            while (--pos > 0 && current.next != null){
                pre = current;
                current= current.next;
            }
            if(pos == 0){
                pre.next = current.next;
            }
        }
    }
}
